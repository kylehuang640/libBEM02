package com.example.libBEM02;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.libBEM02.security.AuthServiceImpl;
import com.example.libBEM02.security.Request.AuthenticationRequest;
import com.example.libBEM02.security.Request.RegisterRequest;
import com.example.libBEM02.security.Response.AuthenticationResponse;
import com.example.libBEM02.service.BooksService;


@SpringBootTest
class LibBem02ApplicationTests {
	AuthenticationRequest auth = new AuthenticationRequest();
	RegisterRequest rr = new RegisterRequest();
	@Autowired
	private AuthServiceImpl authService;
	@Autowired
	private BooksService book;
	
	//if really have to use it, use @BeforeEach instead of @Before and it'll work!
	//but it may produce a lot wasted execution
	
	public void Lsetup() {
		auth.setLoginAccount("root");
		auth.setPassword("123");
	}
	
	public void rrSetup() {
		rr.setName("Kai");
		rr.setLoginAccount("kai");
		rr.setPassword("kai");
		rr.setEmail("kai@gmail.com");
		rr.setMailingAddress("Australia");
		rr.setRole("USER");
		rr.setGender(null);
		rr.setPhoneNum("88674820");
	};
	
	public void setup() {
		
	}
	
	
	@Test
	void contextLoads() throws Exception{
		//======================login test====================================
		Lsetup();
		String prin = authService.login(auth).toString();
		System.out.print(prin);
		//======================register test=================================
		rrSetup();
		AuthenticationResponse au = authService.Register(rr);
		System.out.print(au);
		//======================delete token test==============================
//		String deleteTK = authService.deleteToken();
//		System.out.println(deleteTK);
		//======================check token test==============================
//		String checkToken = authService.test();
//		System.out.print(checkToken);
		
		
	}
}
