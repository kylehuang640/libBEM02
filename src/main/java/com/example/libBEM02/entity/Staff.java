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
	
	
//	public int getID() {
//		return ID;
//	}
//	public void setID(int ID) {
//		this.ID = ID;
//	}
//	public String getStaffName() {
//		return StaffName;
//	}
//	public void setStaffName(String StaffName) {
//		this.StaffName = StaffName;
//	}
//	public String getAccount() {
//		return Account;
//	}
//	public void setAccount(String Account) {
//		this.Account = Account;
//	}
//	public String getPassword() {
//		return Password;
//	}
//	public void setPassword(String Password) {
//		this.Password = Password;
//	}
//	public String getPhoneNum() {
//		return PhoneNum;
//	}
//	public void setPhoneNum(String PhoneNum) {
//		this.PhoneNum = PhoneNum;
//	}
//	public String getEmail() {
//		return Email;
//	}
//	public void setEmail(String Email) {
//		this.Email = Email;
//	}
}
