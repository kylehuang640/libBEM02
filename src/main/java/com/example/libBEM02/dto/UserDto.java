package com.example.libBEM02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	Integer ID;
	String Name;
	String Email;
	String PhoneNum;
	String LoginAccount;
	String Password;
	Integer Gender;
	String MailingAddress;
	
//	public UserDto(String LoginAccount, String Password){
//		this.LoginAccount = LoginAccount;
//		this.Password = Password;
//	}
}
