package com.example.libBEM02.security;

import java.time.Instant;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;
import com.example.libBEM02.security.Request.AuthenticationRequest;
import com.example.libBEM02.security.Request.RegisterRequest;
import com.example.libBEM02.security.Response.AuthenticationResponse;
import com.example.libBEM02.security.Token.*;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
public class AuthServiceImpl {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenRepository tokenRepository;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	// 註冊
	public AuthenticationResponse Register(RegisterRequest req) {
		// 建立一筆新的user
		User user = User.builder().Name(req.getName()).LoginAccount(req.getLoginAccount())
				.Password(passwordEncoder.encode(req.getPassword())).build();

		var SaveUser = userRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		saveUserToken(SaveUser, jwtToken);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	// 驗證、登入
	public AuthenticationResponse login(AuthenticationRequest req) {
		//檢驗登入帳號、密碼
		authenticationManager.authenticate
			(new UsernamePasswordAuthenticationToken(req.getLoginAccount(), req.getPassword()));
		
		var user = userRepository.findByLoginAccount(req.getLoginAccount()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);

		saveUserToken(user, jwtToken);
		return AuthenticationResponse.builder()
				.token(jwtToken).build();
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
	
	
}
