package com.example.libBEM02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.libBEM02.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	
}
