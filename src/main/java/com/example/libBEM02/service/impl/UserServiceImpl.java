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
	UserService userService;
	
	
	private String getPassword(User user) {
		String p = user.getPassword();
		return p;
	}
	@Override //登入帳戶
	public UserDto login(User user) {
		//檢查是否有此人
		User data = userRepository.findByName(user.getName());
		if(data == null) return null;
		//檢查密碼正確與否
		if(!data.getPassword().equals(user.getPassword())) return null;
		
		UserDto ud = new UserDto();
		ud = convertToDto(user);
		return ud;
	};
	@Override //註冊帳戶
	public Optional<String> register(UserDto ud){
		User data = userRepository.findByLoginAccount(ud.getLoginAccount());
		if(data != null) return Optional.of("帳號已註冊"); //如果已經有人註冊相同的帳號，回傳null
		
		//新增user資料
		User user = new User();
		user = convertToEntity(ud);
		userRepository.save(user);
		if(userRepository.findByName(ud.getName()) == null) return Optional.of("帳號新增失敗!");
		
		return Optional.empty();
	};
	@Override
	public User findUserByName(String username) {
		return userRepository.findByName(username);
	};
	
	private UserDto convertToDto(User user) {
		UserDto ud = new UserDto();
		ud.setID(user.getID());
		ud.setName(user.getName());
		ud.setEmail(user.getEmail());
		ud.setLoginAccount(user.getLoginAccount());
		ud.setPassword(user.getPassword());
		ud.setPhoneNum(user.getPhoneNum());
		ud.setGender(user.getGender());
		return ud;
	}
	private User convertToEntity(UserDto ud) {
		User u = new User();
		u.setID(ud.getID());
		u.setName(ud.getName());
		u.setEmail(ud.getEmail());
		u.setLoginAccount(ud.getLoginAccount());
		u.setPassword(ud.getPassword());
		u.setPhoneNum(ud.getPhoneNum());
		u.setGender(ud.getGender());
		return u;
	}
}
