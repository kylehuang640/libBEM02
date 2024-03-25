package com.example.libBEM02.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class OtpGenerator {
	
	
	public Integer GenerateOtp(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		
		return otp;
	}
}
