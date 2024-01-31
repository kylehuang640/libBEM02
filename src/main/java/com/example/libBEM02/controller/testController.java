package com.example.libBEM02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	
	@RequestMapping("/hell")
	public String Hello() {
		return "Hello";
	}
	
	@RequestMapping("/123")
	public String index() {
		return "/hell";
	}
}
