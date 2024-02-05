package com.example.libBEM02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.User;
import com.example.libBEM02.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	//login controller
	@RequestMapping("/login")
	public ResponseEntity<String> Login(@RequestParam String username, @RequestParam String password) {
		boolean log = userService.login(username, password);
		if(log) {
			return new ResponseEntity<>("登入成功!",HttpStatus.OK);	
		}
		return new ResponseEntity<>("帳號或密碼錯誤!",HttpStatus.OK);
	}
	
	//register
	@RequestMapping("/register")
	public ResponseEntity<String> Register(@RequestBody UserDto userDto){
		return new ResponseEntity<>(userService.register(userDto),HttpStatus.OK);
	}
	
	@RequestMapping("/delete")
	public void deleteUser(@RequestParam Integer id) {
		userService.deleteUser(id);
	}
}
