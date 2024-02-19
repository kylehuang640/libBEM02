package com.example.libBEM02.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class UserDto {
	private Integer ID;
	private String Name;
	private String Email;
	private String PhoneNum;
	private String LoginAccount;
	private String Password;
	private Integer Gender;
	private String MailingAddress;
	
//	public UserDto(String LoginAccount, String Password){
//		this.LoginAccount = LoginAccount;
//		this.Password = Password;
//	}
}
