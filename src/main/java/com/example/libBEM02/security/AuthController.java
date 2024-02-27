package com.example.libBEM02.security;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.exception.UserNotFoundException;
import com.example.libBEM02.security.Request.AuthenticationRequest;
import com.example.libBEM02.security.Request.RegisterRequest;
import com.example.libBEM02.security.Response.AuthenticationResponse;
import com.example.libBEM02.security.Response.GenericResponse;
import com.example.libBEM02.service.impl.UserServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthServiceImpl authService;

	private final UserServiceImpl userService;

	private final LogoutService logoutService;
	
	@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authService.Register(request));
    }
	
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
    	return ResponseEntity.ok(authService.login(request));
    }
    
    @PostMapping("/logout")	
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        logoutService.logout(request, response, authentication);
        return ResponseEntity.ok("Logout！");
    }
    
    @PostMapping("/test")
    public ResponseEntity<String> testPostRequest(@RequestBody AuthenticationRequest req)
    {
    	return ResponseEntity.ok(req.getLoginAccount());
    }
    
//    @PostMapping("/log") //測試登入
//    public String log(@RequestBody AuthenticationRequest request) {
//    	return userService.getUser(request.getLoginAccount()).toString();
//    	
//    }
    
    
    
//    public ResponseEntity<GenericResponse> resetPassword(HttpServletRequest request, @RequestParam("Email") String mail) throws UserNotFoundException {
//    	UserDto ud = userService.findByEmail(mail);
//    	if(ud == null) {throw new UserNotFoundException();}
//    	
//    	String token = UUID.randomUUID().toString();
//    	userService.createPasswordResetTokenForUser(ud ,token);
//    	
//    }
}