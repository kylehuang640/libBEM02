package com.example.libBEM02.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;
import com.example.libBEM02.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserDto userDto;
	
	public UserDto login(User user) {
		
	};
	public Optional<String> register(UserDto ud){
		
	};
	
	public User findUserByName(String username) {
		return userRepository.findByName(username);
	};
}
