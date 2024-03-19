package com.example.libBEM02.security;

import java.io.IOException; 
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Service;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;
import com.example.libBEM02.security.Request.AuthenticationRequest;
import com.example.libBEM02.security.Request.RegisterRequest;
import com.example.libBEM02.security.Response.AuthenticationResponse;
import com.example.libBEM02.security.Token.*;
import com.example.libBEM02.service.impl.UserServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
				.Role(req.getRole())
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
		var user = userRepository.findByLoginAccount(req.getLoginAccount()).orElseThrow(()-> new IllegalArgumentException("LoginAccount is invalid！"));		
		if(!user.getPassword().startsWith("$2y")){
			user.setPassword(userService.passwordEncoder().encode(user.getPassword()));
		}
		//authenticate request loginAccount and password
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getLoginAccount(),req.getPassword()));
		//find the relative user  ()-> new IllegalArgumentException("帳號或密碼輸入錯誤！")
		

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
	
	//forgot and reset
	//concept here: in the request body, we need loginAccount but to identify user's identity, if it's correct, then we reset his password into what he entered.
	public UserDto forgotPassword(String loginAccount) {
		UserDto ud = convertToDto(userRepository.findByloginAccount(loginAccount));
		return ud;
	}
	public void resetPassword(UserDto ud, String password) {
		User user = convertToUser(ud);
		user.setPassword(password);
		userRepository.save(user);
	}
	
	public UserDto convertToDto(User user) {
		UserDto ud = new UserDto();
		ud.setID(user.getID());
		ud.setLoginAccount(user.getLoginAccount());
		ud.setPassword(user.getPassword());
		ud.setEmail(user.getEmail());
		ud.setName(user.getName());
		ud.setMailingAddress(user.getMailingAddress());
		ud.setPhoneNum(user.getPhoneNum());
		ud.setGender(user.getGender());
		return ud;
	}
	public User convertToUser(UserDto user) {
		User ud = new User();
		ud.setID(user.getID());
		ud.setLoginAccount(user.getLoginAccount());
		ud.setPassword(user.getPassword());
		ud.setEmail(user.getEmail());
		ud.setName(user.getName());
		ud.setMailingAddress(user.getMailingAddress());
		ud.setPhoneNum(user.getPhoneNum());
		ud.setGender(user.getGender());
		return ud;
	}
}
