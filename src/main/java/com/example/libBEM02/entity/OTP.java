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
public class OTP extends Base{
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
	
	
//	public int getOTPId() {
//		return OTPId;
//	}
//	public void setOTPId(int OTPId) {
//		this.OTPId = OTPId;
//	}
//	public String getOTPcode() {
//		return OTPcode;
//	}
//	public void setOTPcode(String OTPcode) {
//		this.OTPcode = OTPcode;
//	}
//	
//	public String getOTPexpire() {
//		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(OTPexpire);
//	}
//	public void setOTPexpire(Date OTPexpire) {
//		 if (OTPexpire == null) {
//		        throw new IllegalArgumentException("OTPexpire 不能為空");
//		    }
//
//		    this.OTPexpire = OTPexpire;
//	}
//	
//	public int getOTPerror() {
//		return OTPerror;
//	}
//	public void setOTPerror(int OTPerror) {
//		this.OTPerror = OTPerror;
//	}
}
