package com.customerservice.staff.domain.respository;

import java.util.List;

import com.customerservice.staff.domain.model.aggregate.Staff;

public interface StaffRepository {
	
	void save(Staff staff);
	
	Staff findByStaffId(String staffId);
	
	List<Staff> findAll();
}
