package com.customerservice.staff.domain.model.aggregate;

import com.customerservice.staff.domain.command.CreateStaffCommand;

public class Staff {

	private StaffId staffId;
	private String staffName;
	private String description;

	public Staff() {
		
	}
	
	public Staff(CreateStaffCommand createStaffCommand) {
		this.staffId = new StaffId(createStaffCommand.getStaffId());
		this.staffName = createStaffCommand.getStaffName();
		this.description = createStaffCommand.getDescription();
	}

	public StaffId getStaffId() {
		return staffId;
	}

	public void setStaffId(StaffId staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}
