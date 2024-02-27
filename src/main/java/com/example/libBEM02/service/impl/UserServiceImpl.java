package com.example.libBEM02.service.impl;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.libBEM02.dto.StaffDto;
import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.Staff;
import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;
import com.example.libBEM02.security.Request.ChangePasswordRequest;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	//對比資料

//	@Bean
//    public UserDetailsService userDetailsService() {
//        return (username) -> {
//            User user = userRepository.findByLoginAccount(username).orElseThrow();
//            return new org.springframework.security.core.userdetails.User(
//                    user.getLoginAccount(),
//                    user.getPassword(),
//                    new ArrayList<>()
//            );
//        };
//    }
	
	@Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByLoginAccount(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
	
	@Override
    public UserDetails loadUserByUsername(String loginAccount) throws UsernameNotFoundException {
        User user = userRepository.findByloginAccount(loginAccount);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return null;
    }
	
	//test login
    public User getUser(String login) {
    	User user = userRepository.findByloginAccount(login);
    	return user;
    }
    
	
	
	//convert-------------------------------------------
	//將entity轉成dto
	private UserDto convertToDto(User u) {
		UserDto ud = new UserDto();
		ud.setID(u.getID());
		ud.setName(u.getName());
		ud.setEmail(u.getEmail());
		ud.setPhoneNum(u.getPhoneNum());
		ud.setLoginAccount(u.getLoginAccount());
		ud.setPassword(u.getPassword());
		ud.setGender(u.getGender());
		ud.setMailingAddress(u.getMailingAddress());
		return ud;
	};
	//將dto轉成entity
	private User convertToEntity(UserDto ud) {
		User u = new User();
		u.setID(ud.getID());
		u.setName(ud.getName());
		u.setEmail(ud.getEmail());
		u.setPhoneNum(ud.getPhoneNum());
		u.setLoginAccount(ud.getLoginAccount());
		u.setPassword(ud.getPassword());
		u.setGender(ud.getGender());
		u.setMailingAddress(ud.getMailingAddress());
		return u;
	}	    
}