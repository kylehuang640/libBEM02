package com.example.libBEM02.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.libBEM02.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
	@Query(value = "SELECT * FROM Staff s WHERE s.StaffName = :StaffName" ,nativeQuery = true)
	Staff findByStaffName(@Param("StaffName") String StaffName);
}
