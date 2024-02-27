package com.example.libBEM02.security.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	//private Integer Id;
	private String Name;
	private String Email;
	private String PhoneNum;
    private String LoginAccount;
    private String Password;
    private Integer Gender;
    private String MailingAddress;
}