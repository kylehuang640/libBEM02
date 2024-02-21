package com.example.libBEM02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
public class LibBem02Application {
	
	public static void main(String[] args) {
		SpringApplication.run(LibBem02Application.class, args);
	}
}
