package com.example.libBEM02.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.security.Request.AuthenticationRequest;
import com.example.libBEM02.security.Request.RegisterRequest;
import com.example.libBEM02.security.Response.AuthenticationResponse;
import com.example.libBEM02.service.impl.UserServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	@Autowired
	private AuthServiceImpl authService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private LogoutService logoutService;
	
	@Operation(summary = "註冊")
	@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authService.Register(request));
    }
	
	@Operation(summary = "登入")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
		AuthenticationResponse resp = authService.login(request);
		return ResponseEntity.ok(resp);
    }
    
	@Operation(summary = "登出")
    @PostMapping("/logout")	
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        logoutService.logout(request, response, authentication);
        return ResponseEntity.ok("Logout!");
    }
	
	@Operation(summary = "查看token")
    @PostMapping("/history")
    public String tokenHistoryCheck(){
    	return authService.test();
    }
	
	@Operation(summary = "刪除token")
    @DeleteMapping("/delete")
    public String deleteTokenRequest() {
    	return authService.deleteToken();
    }
	
	@Operation(summary = "忘記密碼")
	@PostMapping("/forgot")
	public void forgotPassword(@RequestBody String Email) {
		UserDto ud = authService.forgotPassword(Email);
		//after confirm his identity
		//send email to user, authenticate
	}
	
	@PostMapping("/reset")
	public void resetPassword(UserDto ud,String Password) {
		//reset password
		authService.resetPassword(ud, Password);
	}
	
}