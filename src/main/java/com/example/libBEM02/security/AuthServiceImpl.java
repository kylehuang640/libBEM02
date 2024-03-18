package com.example.libBEM02.security;

import java.io.IOException; 
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;
import com.example.libBEM02.security.Request.AuthenticationRequest;
import com.example.libBEM02.security.Request.RegisterRequest;
import com.example.libBEM02.security.Response.AuthenticationResponse;
import com.example.libBEM02.security.Token.*;
import com.example.libBEM02.service.impl.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenRepository tokenRepository;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private TokenRepository token;
	
	// register
	public AuthenticationResponse Register(RegisterRequest req) {
		
		//create new user
		User user = User.builder()
				.Name(req.getName())
				.Email(req.getEmail())
				.loginAccount(req.getLoginAccount())
				.password(userService.passwordEncoder().encode(req.getPassword()))
				.Gender(req.getGender())
				.MailingAddress(req.getMailingAddress())
				.build();

		var SaveUser = userRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		saveUserToken(SaveUser, jwtToken);
		return AuthenticationResponse.builder()
				.message("ADD USER SUCCESS!")
				.token(jwtToken)
				.build();
	}
	
	public AuthenticationResponse login(AuthenticationRequest req) {
		//authenticate request loginAccount and password
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getLoginAccount(),req.getPassword()));
		//find the relative user  ()-> new IllegalArgumentException("帳號或密碼輸入錯誤！")
		var user = userRepository.findByLoginAccount(req.getLoginAccount()).orElseThrow(()-> new IllegalArgumentException("LoginAccount is invalid！"));		
		
		var jwtToken = jwtService.generateToken(user);
		saveUserToken(user, jwtToken);
		return AuthenticationResponse.builder()
				.message("LOGIN SUCCESS!")
				.token(jwtToken)
				.build();
	}
	
	//test value
	public String test( ) {
		String list = token.findAll().toString();
		return list;		
	}
	
	//delete all token
	public String deleteToken() {
		token.deleteAll();
		return "DELETE SUCCESS!";
	}

	// save token
	private void saveUserToken(User user, String jwtToken) {
		var token = Token
				.builder()
				.user(user)
				.token(jwtToken)
				.tokenType(TokenType.BEARER)
				.expired(false)
				.revoked(false)
				.build();
		tokenRepository.save(token);
	}
	
	
	//generate the token that is using for password reset
	public void createPasswordResetTokenForUser(User user, String token) {
		
	}
}
