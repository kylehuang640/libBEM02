package com.example.libBEM02.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import com.example.libBEM02.security.Token.TokenRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {
    private final TokenRepository tokenRepository;
    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {
            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            // 以下條件為沒有攜帶Token的請求
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return;
            }
            jwt = authHeader.substring(7);
            var storedToken = tokenRepository.findByToken(jwt).orElseThrow();
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
    }
};
