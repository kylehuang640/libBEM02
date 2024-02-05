package com.example.libBEM02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.dto.StaffDto;
import com.example.libBEM02.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	StaffService staffService;
	
	//Request Test 
    @RequestMapping("/get/{staffname}")
    public ResponseEntity<StaffDto> get(@PathVariable String staffname){
    	StaffDto sd = staffService.findByStaffName(staffname);
    	return new ResponseEntity<>(sd, HttpStatus.OK);
    }
	
	//Request all data
    @RequestMapping("/get/All")
    public List<StaffDto> findAll(){
    	List<StaffDto> staff = staffService.findAll();
    	return staff;
    }
    
	//Delete
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteBooks(Integer id){
		staffService.deleteStaff(id);
		return ResponseEntity.ok("Delete Success!");
	}
	//Create
	@PostMapping("/create")
    public ResponseEntity<StaffDto> createBook(@RequestBody StaffDto staffDto) {
        StaffDto sd = staffService.insertStaff(staffDto);
        return new ResponseEntity<>(sd, HttpStatus.CREATED);
    }
	//update
    @PutMapping("/update/{id}")
    public ResponseEntity<StaffDto> updateBook(@PathVariable Integer id, @RequestBody StaffDto staffDto) {
    	StaffDto updateS = staffService.updateStaff(id, staffDto);
        staffService.updateStaff(id, staffDto);
        return ResponseEntity.ok(updateS);
    }
}
