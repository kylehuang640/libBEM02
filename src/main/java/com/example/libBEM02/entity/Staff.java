package com.example.libBEM02.entity;

import jakarta.persistence.*; 

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@Table(name = "Staff")
@ToString
public class Staff extends Base{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "StaffName")
	private String StaffName;
	@Column(name = "Account")
	private String Account;
	@Column(name = "Password")
	private String Password;
	@Column(name = "PhoneNum")
	private String PhoneNum;
	@Column(name = "Email")
	private String Email;
	
}
