package com.example.libBEM02.security.Token;

import java.util.Date;

import com.example.libBEM02.entity.User;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PasswordResetToken {
	private static final int EXPIRATION = 60 * 24;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String token;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private User user;
	
	private Date expireDate;
	
	public PasswordResetToken() {
		super();
	}
	
}
