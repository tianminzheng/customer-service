package com.customerservice.staff.infrastructure.repository.factory;

import org.springframework.stereotype.Service;

import com.customerservice.staff.domain.model.aggregate.Staff;
import com.customerservice.staff.domain.model.aggregate.StaffId;
import com.customerservice.staff.infrastructure.repository.po.StaffPO;

@Service
public class StaffFactory {

	 public StaffPO creatStaffPO(Staff staff){
		 StaffPO staffPO = new StaffPO();
		 staffPO.setStaffId(staff.getStaffId().getStaffId());
		 staffPO.setStaffName(staff.getStaffName());
		 staffPO.setDescription(staff.getDescription());
		 
		 return staffPO;
	 }
	 
	 public Staff creatStaff(StaffPO staffPO){
		 Staff staff = new Staff();
		 staff.setStaffId(new StaffId(staffPO.getStaffId()));
		 staff.setStaffName(staffPO.getStaffName());
		 staff.setDescription(staffPO.getDescription());
		 
		 return staff;
	 }
}
