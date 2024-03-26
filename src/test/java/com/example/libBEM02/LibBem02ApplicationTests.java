package com.example.libBEM02;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import com.example.libBEM02.dto.StaffDto;
import com.example.libBEM02.security.AuthServiceImpl;
import com.example.libBEM02.security.LogoutService;
import com.example.libBEM02.security.Request.AuthenticationRequest;
import com.example.libBEM02.security.Request.RegisterRequest;
import com.example.libBEM02.security.Response.AuthenticationResponse;
import com.example.libBEM02.service.BooksService;
import com.example.libBEM02.service.impl.StaffServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@SpringBootTest
class LibBem02ApplicationTests {
	AuthenticationRequest auth = new AuthenticationRequest();
	RegisterRequest rr = new RegisterRequest();
	StaffDto sf = new StaffDto();
	@Autowired
	private AuthServiceImpl authService;
	@Autowired
	private BooksService book;
	@Autowired
	private StaffServiceImpl ssi;
	@Autowired
	private LogoutService logout;
	
	//if really have to use it, use @BeforeEach instead of @Before and it'll work!
	//but it may produce a lot wasted execution
	
	//Login
	public void Lsetup() {
		auth.setLoginAccount("root");
		auth.setPassword("123");
	}
	//Register
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
	//Staff Insert
	public void sfSetup() {
		sf.setID(123);
		sf.setStaffName("Eric");
		sf.setPhoneNum("701943");
		sf.setEmail("eric@gmail.com");
		sf.setAccount("eric");
		sf.setPassword("eric");
	}
	/*
	@Test
	void login() throws Exception{
		//======================login test====================================
		Lsetup();
		String prin = authService.login(auth).toString();
		System.out.print(prin);
	}
	@Test
	void register() throws Exception{
		//======================register test=================================
		rrSetup();
		AuthenticationResponse au = authService.Register(rr);
		System.out.print(au);
	}
	*/
	
	@Test
	void staffAll() {
		String all = ssi.findAll().toString();
		System.out.print(all);
	}
	
	@Test
	void staffInsert() {
		sfSetup();
		String sfIns = ssi.insertStaff(sf).toString();
		System.out.print(sfIns);
	}
	
	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse res;
	@Mock
	Authentication authentication;
	
	@Test
	void logout() {
		when(req.getHeader("Authorization")).thenReturn("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdHkiOlt7ImF1dGhvcml0eSI6IkFETUlOIn1dLCJzdWIiOiJ0cmlnZ2VyIiwiaWF0IjoxNzExMzM0MTMwLCJleHAiOjE3MTEzMzc3MzB9.Mq56nGXwXBOvMP6gzAnRaSsWdJnhca0NJFBlnfBh8f4");
		//request, response, authentication
		logout.logout(req, res, authentication);
	}
}
