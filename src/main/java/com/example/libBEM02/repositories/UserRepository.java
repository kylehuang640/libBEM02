package com.example.libBEM02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.libBEM02.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM User u WHERE u.Name = :username" , nativeQuery = true)
	public User findByName(@Param("username") String username);
	
	@Query(value = "SELECT * FROM User u WHERE u.LoginAccount = :loginAccount", nativeQuery = true)
	public User findByLoginAccount(@Param("loginAccount") String LAcccount);
	
	//測試email的使用情形
	@Query(value = "SELECT * FROM User u WHERE u.Email = :Email" , nativeQuery = true)
	public User findByEmail(@Param("Email") String Email);
}
