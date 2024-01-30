package com.example.libBEM02.entity;

import jakarta.persistence.*; 

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter @Setter
@Table(name = "User")
@ToString
public class User extends Base{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",unique = true)
	private Integer ID;
	@Column(name = "Name")
	private String Name;
	@Column(name = "Email")
	private String Email;
	@Column(name = "PhoneNum")
	private String PhoneNum;
	@Column(name = "LoginAccount")
	private String LoginAccount;
	@Column(name = "Password")
	private String Password;
	@Column(name = "Gender")
	private Integer Gender;
	@Column(name = "MailingAddress")
	private String MailingAddress;
	
}
