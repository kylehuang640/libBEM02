package com.example.libBEM02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.libBEM02.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{
	
}
