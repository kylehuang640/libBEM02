package com.example.libBEM02.entity;

import javax.persistence.Column; 
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "Log_Check")
@ToString
public class Log_Check extends Base{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginID")
	private Integer loginID;
	
	@ManyToOne
    @JoinColumn(name = "userID",nullable = false)
    private User user;
	
	@Column(name = "LoginTime")
	@JsonFormat(pattern="yyyy-mm-dd HH:mm:ss")
	private Date LoginTime;
	@Column(name = "LoginAccount")
	private String LoginAccount;
	@Column(name = "IpAddress")
	private String IpAddress;
	@Column(name = "Status")
	private Integer Status;
	@Column(name = "LogType")
	private Integer LogType;
	
	
	
//	public int getloginID() {
//		return loginID;
//	}
//	public void setloginID(int loginID) {
//		this.loginID = loginID;
//	}
//	//foreign key/ MUL key
//	public Integer getuserID() {
//		return user.getID();
//	}
//	public void setuserID(User user) {
//		this.user = user;
//	}
//	
//	public String getLoginTime() {
//		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LoginTime);
//	}
//	public void setLoginTime(Date LoginTime) {
//		 if (LoginTime == null) {
//		        throw new IllegalArgumentException("loginTime 不能為空");
//		    }
//
//		    this.LoginTime = LoginTime;
//	}
//	
//	public String LoginAccount() {
//		return LoginAccount;
//	}
//	public void setLoginAccount(String LoginAccount) {
//		this.LoginAccount = LoginAccount;
//	}
//	public String getIpAddress() {
//		return IpAddress;
//	}
//	public void setIpAddress(String IpAddress) {
//		this.IpAddress = IpAddress;
//	}
//	public int getStatus() {
//		return Status;
//	}
//	public void setStatus(int Status) {
//		this.Status = Status;
//	}
//	public int getLogType() {
//		return LogType;
//	}
//	public void setLogType(int LogType) {
//		this.LogType = LogType;
//	}
}
