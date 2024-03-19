package com.example.libBEM02.security;	

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.libBEM02.security.Token.TokenRepository;
import com.example.libBEM02.service.impl.UserServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    
    private final JwtService jwtService;
    
    private final TokenRepository tokenRepository;
    
    private final UserServiceImpl userService;
            
    @Override
    public void doFilterInternal(@NonNull HttpServletRequest request,
                                 @NonNull HttpServletResponse response,
                                 @NonNull FilterChain filterChain) throws ServletException, IOException {
    	final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userAccount;
        // without Jwt token or start with "Bearer ", then call filterChain.dofilter, handling those afterwards filter or functions
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        	filterChain.doFilter(request, response);
        	return;
        }
        jwt = authHeader.substring(7); 	//extract those tokens after "Bearer "
        userAccount = jwtService.extractUserName(jwt); //extract LoginAccount in the token
        // if username not null and current SecurityContext doesn't exist identity authentication
        if (userAccount != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
            	// by using UserDetailsService to load User Details
            	UserDetails userDetails = userService.loadUserByUsername(userAccount);
            	SecurityContext context = SecurityContextHolder.createEmptyContext();
                if (jwtService.isTokenValid(jwt, userDetails)) {
                	// if token works, create UsernamePasswordAuthenticationToken and set it into Spring context, make sure it is authenticated
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    		userDetails, 
                    		null, 
                    		userDetails.getAuthorities()
                    );
                authToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }else {
            	response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                String errorMessage = "Token has expired";
                String jsonErrorMessage = "{\"status\": \"1\", \"message\": \"" + errorMessage + "\"}";
                response.getWriter().write(jsonErrorMessage);
                return;
            	}
            }catch(ExpiredJwtException e) {
            	throw e;
            }
        }
        filterChain.doFilter(request, response);
    }
}