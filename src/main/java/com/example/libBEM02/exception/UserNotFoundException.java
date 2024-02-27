package com.example.libBEM02.exception;

public class UserNotFoundException extends java.lang.Exception{
	private String username;
	
	public UserNotFoundException() {
		super("使用者名稱錯誤或不存在!");
	}
	public String getUsername() {
		return username;
	}
}
