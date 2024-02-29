package com.example.libBEM02.security;

import java.io.IOException; 
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl {
	
	private final UserRepository userRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private final TokenRepository tokenRepository;
	@Autowired
	private final JwtService jwtService;
	@Autowired
	private final AuthenticationManager authenticationManager;
	@Autowired
	private final UserServiceImpl userService;

	// 註冊
	public AuthenticationResponse Register(RegisterRequest req) {
		// 建立一筆新的user
		User user = User.builder()
				.Name(req.getName())
				.Email(req.getEmail())
				.loginAccount(req.getLoginAccount())
				.password(passwordEncoder.encode(req.getPassword()))
				.Gender(req.getGender())
				.MailingAddress(req.getMailingAddress())
				.build();

		var SaveUser = userRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		saveUserToken(SaveUser, jwtToken);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
	
	
//	public AuthenticationResponse login(AuthenticationRequest req) {
//		//檢驗登入帳號、密碼
//		authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(
//						req.getLoginAccount(), 
//						req.getPassword()
//				)
//		);
//		//尋找對應的帳密  () -> new IllegalArgumentException("帳號或密碼輸入錯誤！"))
//		var user = userRepository.findByLoginAccount(req.getLoginAccount()).orElseThrow();
//		
//		var jwtToken = jwtService.generateToken(user);
//		saveUserToken(user, jwtToken);
//		return AuthenticationResponse.builder()
//				.token(jwtToken)
//				.build();
//	}
	
	//authenticate and save the user
	public AuthenticationResponse login(AuthenticationRequest req) {
		// Find user with corresponding login account (throw exception if not found)
	    var user = userRepository.findByLoginAccount(req.getLoginAccount())
	            .orElseThrow(() -> new IllegalArgumentException("Account or password is incorrect!"));
	    
	    // Check login credentials
	    authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                    req.getLoginAccount(),
	                    passwordEncoder.encode(req.getPassword())
	            )
	    );

	    

	    // Encode password with Bcrypt
	    String encodedPassword = passwordEncoder.encode(req.getPassword());

	    // Check if the encoded password matches the user's password
	    if (!passwordEncoder.matches(encodedPassword, user.getPassword())) {
	        throw new IllegalArgumentException("Account or password is incorrect!");
	    }

	    // Generate JWT token
	    var jwtToken = jwtService.generateToken(user);

	    // Save user token
	    saveUserToken(user, jwtToken);

	    return AuthenticationResponse.builder()
	            .token(jwtToken)
	            .build();
	}

	// 儲存token
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
	
	//產生重置密碼的token
	public void createPasswordResetTokenForUser(User user, String token) {
		
	}
}
