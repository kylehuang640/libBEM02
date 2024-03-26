package com.example.libBEM02.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libBEM02.dto.StaffDto;
import com.example.libBEM02.entity.Staff;
import com.example.libBEM02.exception.ResourceNotFoundException;
import com.example.libBEM02.repositories.StaffRepository;

@Service
public class StaffServiceImpl{
	@Autowired
	StaffRepository staffRepository;
	
	public StaffDto findByStaffName(String StaffName) {
		Staff sa = staffRepository.findByStaffName(StaffName);
		return convertToDto(sa);
	};
	
	public List<StaffDto> findAll(){
		List<Staff> sa = staffRepository.findAll();
		return convertListToDto(sa);
	};
	
	public StaffDto insertStaff(StaffDto sd) {
		Staff sf = new Staff();
    	sf.setID(sd.getID());
		sf.setStaffName(sd.getStaffName());
		sf.setAccount(sd.getAccount());
		sf.setPassword(sd.getPassword());
		sf.setPhoneNum(sd.getPhoneNum());
		sf.setEmail(sd.getEmail());
		
		Staff saveSF = staffRepository.save(sf);
		return convertToDto(saveSF);
	};
	
	public void deleteStaff(Integer ID) {
		staffRepository.deleteById(ID);
	};
	
    public StaffDto updateStaff(Integer id, StaffDto staffDto) {
		Staff existingStaff = staffRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find employee whose ID:" + id ));
		existingStaff.setID(staffDto.getID());
		existingStaff.setStaffName(staffDto.getStaffName());
		existingStaff.setAccount(staffDto.getAccount());
		existingStaff.setPassword(staffDto.getPassword());
		existingStaff.setPhoneNum(staffDto.getPhoneNum());
		existingStaff.setEmail(staffDto.getEmail());
        staffRepository.save(existingStaff);
        
        StaffDto s = convertToDto(existingStaff);
        return s;
	};
	
	
	//convert-------------------------------------------
		//turn entity into dto
		private StaffDto convertToDto(Staff sf) {
			StaffDto sd = new StaffDto();
			sd.setID(sf.getID());
			sd.setStaffName(sf.getStaffName());
			sd.setAccount(sf.getAccount());
			sd.setPassword(sf.getPassword());
			sd.setPhoneNum(sf.getPhoneNum());
			sd.setEmail(sf.getEmail());
			return sd;
		};
		//turn dto into entity
	    private Staff convertToEntity(StaffDto sd) {
	    	Staff sf = new Staff();
	    	sf.setID(sd.getID());
			sf.setStaffName(sd.getStaffName());
			sf.setAccount(sd.getAccount());
			sf.setPassword(sd.getPassword());
			sf.setPhoneNum(sd.getPhoneNum());
			sf.setEmail(sd.getEmail());
	    	return sf;
	    };
	    //turn Entity List into Dto List
	    private List<StaffDto> convertListToDto(List<Staff> sf){
	    	List<StaffDto> ret = new ArrayList<StaffDto>(); 
	    	for( Staff s : sf) {
	    		ret.add(convertToDto(s));
	    	}
	    	return ret;
	    }
}
