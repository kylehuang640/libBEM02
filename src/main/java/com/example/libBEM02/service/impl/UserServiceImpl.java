package com.example.libBEM02.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.libBEM02.dto.StaffDto;
import com.example.libBEM02.dto.UserDto;
import com.example.libBEM02.entity.Staff;
import com.example.libBEM02.entity.User;
import com.example.libBEM02.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	//對比資料

//	@Bean
//    public UserDetailsService userDetailsService() {
//        return (LoginAccount) -> {
//            var user = userRepository.findByLoginAccount(LoginAccount).orElseThrow();
//            return new org.springframework.security.core.userdetails.User(
//                    user.getLoginAccount(),
//                    user.getPassword(),
//                    new ArrayList<>()
//            );
//        };
//    }
	
	@Bean
	public UserDetailsService userDetailsService() {
	  return LoginAccount -> userRepository.findByLoginAccount(LoginAccount)
	      .orElseThrow(() -> new UsernameNotFoundException("使用者帳號不存在!"));
	}
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByName(username));
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return null;
    }
    
	
	//delete
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	};
	
	//convert-------------------------------------------
	//將entity轉成dto
	private UserDto convertToDto(User u) {
		UserDto ud = new UserDto();
		ud.setID(u.getID());
		ud.setName(u.getName());
		ud.setEmail(u.getEmail());
		ud.setPhoneNum(u.getPhoneNum());
		ud.setLoginAccount(u.getLoginAccount());
		ud.setPassword(u.getPassword());
		ud.setGender(u.getGender());
		ud.setMailingAddress(u.getMailingAddress());
		return ud;
	};
	//將dto轉成entity
	private User convertToEntity(UserDto ud) {
		User u = new User();
		u.setID(ud.getID());
		u.setName(ud.getName());
		u.setEmail(ud.getEmail());
		u.setPhoneNum(ud.getPhoneNum());
		u.setLoginAccount(ud.getLoginAccount());
		u.setPassword(ud.getPassword());
		u.setGender(ud.getGender());
		u.setMailingAddress(ud.getMailingAddress());
		return u;
	}	    
}