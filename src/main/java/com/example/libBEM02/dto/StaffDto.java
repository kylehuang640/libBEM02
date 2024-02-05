package com.example.libBEM02.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class StaffDto {
	private Integer ID;

	private String StaffName;

	private String Account;

	private String Password;

	private String PhoneNum;

	private String Email;
}
