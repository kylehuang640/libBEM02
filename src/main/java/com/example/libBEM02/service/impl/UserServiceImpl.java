package com.example.libBEM02.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libBEM02.dto.StaffDto;
import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.Staff;
import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;
import com.example.libBEM02.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	//對比資料
	@Override
	public UserDto loadUserByName(String username) {
		User u = userRepository.findByName(username);
		return convertToDto(u);
	};
	//login
	@Override
	public boolean login(String LoginAccount ,String Password) {
		User u = userRepository.findByLoginAccount(LoginAccount);
		if(Password.equals(u.getPassword())) {
			return true;
		}
		return false;
	};
	//register
	@Override
	public String register(UserDto ud){
		
		if( userRepository.findByEmail(ud.getEmail())== null ) {
			if( userRepository.findByLoginAccount(ud.getLoginAccount())==null ) {
				User u = new User();
				u.setID(ud.getID());
				u.setName(ud.getName());
				u.setEmail(ud.getEmail());
				u.setPhoneNum(ud.getPhoneNum());
				u.setLoginAccount(ud.getLoginAccount());
				u.setPassword(ud.getPassword());
				u.setGender(ud.getGender());
				u.setMailingAddress(ud.getMailingAddress());
				
				User CreateUser = userRepository.save(u);
				return "註冊成功!";
			}
			return "帳號已被使用。";
		}
		return "Email已被註冊。";
	};
	
	//forgot password
	
	
	//delete
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	};
	
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
	};		    
}