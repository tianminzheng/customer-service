package com.customerservice.staff.application.queryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.staff.domain.model.aggregate.Staff;
import com.customerservice.staff.domain.respository.StaffRepository;

@Service
public class StaffQueryService {

	private StaffRepository staffRepository;
	
	public StaffQueryService(StaffRepository staffRepository) {

		this.staffRepository = staffRepository;
	}

	public Staff findByStaffId(String staffId) {
		return staffRepository.findByStaffId(staffId);
	}

	public List<Staff> findAll() {
		return staffRepository.findAll();
	}
}
