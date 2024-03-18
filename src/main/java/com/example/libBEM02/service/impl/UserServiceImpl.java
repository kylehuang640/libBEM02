package com.example.libBEM02.service.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	// password encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y);
    }
	
	//對比資料
	@Bean
    public UserDetailsService userDetailsService() {
		//return new UserServiceImpl();
        return username -> userRepository.findByLoginAccount(username)
        		.orElseThrow(()-> new UsernameNotFoundException("Username not found!"));
    }
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByLoginAccount(username)
				.orElseThrow(()-> new UsernameNotFoundException("username or password invalid!"+ username));
		if(!user.getPassword().startsWith("$2y")){
			user.setPassword(passwordEncoder().encode(user.getPassword()));
		}
		return user;
    }
	/* 將這段更換成直接回傳現有User
	 * return new org.springframework.security.core.userdetails.User(
    	user.getLoginAccount(), 
    	user.getPassword(),
    	null);*/
    
	
	
    
	//convert-------------------------------------------
	//將entity轉成dto
//	private UserDto convertToDto(User u) {
//		UserDto ud = new UserDto();
//		ud.setID(u.getID());
//		ud.setName(u.getName());
//		ud.setEmail(u.getEmail());
//		ud.setPhoneNum(u.getPhoneNum());
//		ud.setLoginAccount(u.getLoginAccount());
//		ud.setPassword(u.getPassword());
//		ud.setGender(u.getGender());
//		ud.setMailingAddress(u.getMailingAddress());
//		return ud;
//	};
//	//將dto轉成entity
//	private User convertToEntity(UserDto ud) {
//		User u = new User();
//		u.setID(ud.getID());
//		u.setName(ud.getName());
//		u.setEmail(ud.getEmail());
//		u.setPhoneNum(ud.getPhoneNum());
//		u.setLoginAccount(ud.getLoginAccount());
//		u.setPassword(ud.getPassword());
//		u.setGender(ud.getGender());
//		u.setMailingAddress(ud.getMailingAddress());
//		return u;
//	}	    
}