package com.customerservice.domain.model.entity;

import java.io.Serializable;

public class StaffProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private String staffId;
	private String staffName;
	private String description;

	public StaffProfile() {
	}

	public StaffProfile(String staffId, String staffName, String description) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.description = description;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
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
