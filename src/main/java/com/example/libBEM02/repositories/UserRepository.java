package com.example.libBEM02.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.libBEM02.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM User u WHERE u.Name = :username" , nativeQuery = true)
	User findByName(@Param("username") String username);
	
	@Query(value = "SELECT * FROM User u WHERE u.Name = :username" , nativeQuery = true)
	Optional<User> findByUsername(@Param("username") String username);
	
	Optional<User> findByLoginAccount(@Param("loginAccount") String LoginAcccount);
	
	//測試email的使用情形
	@Query(value = "SELECT * FROM User u WHERE u.Email = :Email" , nativeQuery = true)
	User findByEmail(@Param("Email") String Email);
	
	@Query(value = "SELECT * FROM User u WHERE u.LoginAccount = :loginAccount", nativeQuery = true)
	User findByloginAccount(@Param("loginAccount") String loginAccount);
}
