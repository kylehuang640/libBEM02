package com.example.libBEM02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.stereotype.Repository;

import com.example.libBEM02.entity.OTP;

@Repository
public interface OTPRepository extends JpaRepository<OTP,Integer>{
	
}
