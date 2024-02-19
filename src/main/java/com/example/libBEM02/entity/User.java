package com.example.libBEM02.entity;

import java.time.Instant;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter @Setter
@AllArgsConstructor
@Builder
@Table(name = "User")
@ToString
public class User implements UserDetails{
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
	
	public User() {
		
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return LoginAccount;
	}
	
	@Override
    public String getPassword(){ return  Password; }
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
