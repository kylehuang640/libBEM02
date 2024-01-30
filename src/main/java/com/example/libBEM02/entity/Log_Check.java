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
	
}
