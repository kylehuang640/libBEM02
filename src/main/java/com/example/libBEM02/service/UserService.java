package com.example.libBEM02.service;

import java.util.Optional;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.User;

public interface UserService {
	
	public UserDto loadUserByName(String username);
	
	public boolean login(String LoginAccout, String Password);
	
	public String register(UserDto ud);
	
//	public UserDto forgotPassword() {
//		
//	}
	
	public void deleteUser(Integer id);
}
