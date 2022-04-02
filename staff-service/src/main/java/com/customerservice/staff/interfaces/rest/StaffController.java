package com.customerservice.staff.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.domain.model.entity.StaffProfile;
import com.customerservice.dto.FindOptimalStaffDTO;
import com.customerservice.staff.application.commandservice.StaffCommandService;
import com.customerservice.staff.application.queryservice.StaffQueryService;
import com.customerservice.staff.domain.command.CreateStaffCommand;
import com.customerservice.staff.domain.model.aggregate.Staff;
import com.customerservice.staff.interfaces.rest.assembler.CreateStaffCommandDTOAssembler;
import com.customerservice.staff.interfaces.rest.dto.CreateStaffDTO;

@RestController
@RequestMapping(value = "staffs")
public class StaffController {

	private StaffCommandService staffCommandService;
	private StaffQueryService staffQueryService;

	public StaffController(StaffCommandService staffCommandService,
			StaffQueryService staffQueryService) {
		this.staffCommandService = staffCommandService;
		this.staffQueryService = staffQueryService;
	}	
	
	@GetMapping(value = "/{staffId}")
	public Staff getStaffById(@PathVariable String staffId) {
		 
		return staffQueryService.findByStaffId(staffId);
	}
	
	@PostMapping(value = "/profile")
	public StaffProfile getOptimalStaff(@RequestBody FindOptimalStaffDTO findOptimalStaffDTO) {
		 
		List<Staff> staffs = staffQueryService.findAll();
		
		//这里对获取最合适客服人员的实现过程做简化处理，默认以Staff列表的第一个作为最优健康计划
		Staff optimalStaff = staffs.get(0);
		
		return new StaffProfile(optimalStaff.getStaffId().getStaffId(), optimalStaff.getStaffName(), optimalStaff.getDescription());
	}
	
	@PostMapping(value = "/")
	public void createStaff(@RequestBody CreateStaffDTO createStaffDTO) {
		
		CreateStaffCommand createStaffCommand = CreateStaffCommandDTOAssembler.toCommandFromDTO(createStaffDTO);
		staffCommandService.handleStaffCreation(createStaffCommand);
	}
	
}
