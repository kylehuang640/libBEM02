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
	
	
//	public int getID() {
//		return ID;
//	}
//	public void setID(int ID) {
//		this.ID = ID;
//	}
//	public String getName() {
//		return Name;
//	}
//	public void setName(String Name) {
//		this.Name = Name;
//	}
//	public String getEmail() {
//		return Email;
//	}
//	public void setEmail(String Email) {
//		this.Email = Email;
//	}
//	public String getPhoneNum() {
//		return PhoneNum;
//	}
//	public void setPhoneNum(String PhoneNum) {
//		this.PhoneNum = PhoneNum;
//	}
//	public String getLoginAccount() {
//		return LoginAccount;
//	}
//	public void setLoginAccount(String LoginAccount) {
//		this.LoginAccount = LoginAccount;
//	}
//	public String getPassword() {
//		return Password;
//	}
//	public void setPassword(String Password) {
//		this.Password = Password;
//	}
//	public int getGender() {
//		return Gender;
//	}
//	public void setGender(Integer Gender) {
//		this.Gender = Gender;
//	}
//	public String getMailiingAddress() {
//		return MailingAddress;
//	}
//	public void setMailingAddress(String MailingAddress) {
//		this.MailingAddress = MailingAddress;
//	}
}
