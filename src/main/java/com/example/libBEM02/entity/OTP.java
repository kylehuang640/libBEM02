package com.example.libBEM02.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "OTP")
@ToString
public class OTP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OTPId")
	private Integer OTPId;
	@Column(name = "OTPcode")
	private String OTPcode;
	@Column(name = "OTPexpire")
	@JsonFormat(pattern="yyyy-mm-dd HH:mm:ss")
	private Date OTPexpire;
	@Column(name = "OTPerror")
	private Integer OTPerror;
	
	public OTP() {
		super();
	}
}
