package com.example.libBEM02.service;

import java.util.Optional;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.User;

public interface UserService {
	public UserDto login(User user);
	public Optional<String> register(UserDto ud);
	
	public User findUserByName(String username);
}
