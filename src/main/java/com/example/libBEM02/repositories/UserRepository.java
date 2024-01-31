package com.example.libBEM02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.libBEM02.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select * from User u where u.Name = :username")
	public User findByName(@Param("username") String username);
}
