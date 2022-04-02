package com.customerservice.staff.application.commandservice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.customerservice.staff.domain.command.CreateStaffCommand;
import com.customerservice.staff.domain.command.UpdateStaffCommand;
import com.customerservice.staff.domain.model.aggregate.Staff;
import com.customerservice.staff.domain.model.aggregate.StaffId;
import com.customerservice.staff.domain.respository.StaffRepository;

@Service
public class StaffCommandService {

	private StaffRepository staffRepository;
	
	public StaffCommandService(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}
	
	public StaffId handleStaffCreation(CreateStaffCommand createStaffCommand) {
		
		String staffId = "Staff" + UUID.randomUUID().toString().toUpperCase();
		createStaffCommand.setStaffId(staffId);
		
		Staff staff = new Staff(createStaffCommand);
		staffRepository.save(staff);
		
		return staff.getStaffId();
	}
	
	public void handleStaffUpdating(UpdateStaffCommand updateStaffCommand) {
		
		Staff staff = staffRepository.findByStaffId(updateStaffCommand.getStaffId());
		staff.setStaffName(updateStaffCommand.getStaffName());
		staff.setDescription(updateStaffCommand.getDescription());
		
		staffRepository.save(staff);
	}
}
