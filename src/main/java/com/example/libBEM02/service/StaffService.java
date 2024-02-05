package com.example.libBEM02.service;

import java.util.List;

import com.example.libBEM02.dto.StaffDto;

public interface StaffService {
	
	public StaffDto findByStaffName(String StaffName);
	
	public List<StaffDto> findAll();
	
	public StaffDto insertStaff(StaffDto bd);
	
	public void deleteStaff(Integer ID);

    public StaffDto updateStaff(Integer id, StaffDto staffDto);
}
