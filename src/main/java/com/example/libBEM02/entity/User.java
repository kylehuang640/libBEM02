package com.example.libBEM02.entity;

import java.time.Instant;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
	private String loginAccount;
	@Column(name = "Password")
	private String password;
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
		return loginAccount;
	}
	
	@Override
    public String getPassword(){ 
		return  password; 
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	/*User: LoginAccount: Password
	 * look  | look      | 321
	 * peter | peter@gmail.com| 1234
	 * root  | root      | 123 */
	
}
