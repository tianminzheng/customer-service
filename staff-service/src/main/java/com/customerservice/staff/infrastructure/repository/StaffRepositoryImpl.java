package com.customerservice.staff.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.customerservice.staff.domain.model.aggregate.Staff;
import com.customerservice.staff.domain.respository.StaffRepository;
import com.customerservice.staff.infrastructure.repository.factory.StaffFactory;
import com.customerservice.staff.infrastructure.repository.mapper.StaffMapper;
import com.customerservice.staff.infrastructure.repository.po.StaffPO;

@Repository
public class StaffRepositoryImpl implements StaffRepository {

	private StaffMapper staffMapper;
	private StaffFactory staffFactory;

	public StaffRepositoryImpl(StaffMapper staffMapper,
			StaffFactory staffFactory) {
		this.staffMapper = staffMapper;
		this.staffFactory = staffFactory;
	}
	
	@Override
	public void save(Staff staff) {
		StaffPO staffPO = staffFactory.creatStaffPO(staff);
		staffMapper.save(staffPO);
	}

	@Override
	public Staff findByStaffId(String staffId) {
		StaffPO staffPO = staffMapper.findByStaffId(staffId);
		return staffFactory.creatStaff(staffPO);
	}

	@Override
	public List<Staff> findAll() {
		List<StaffPO> staffPOs = staffMapper.findAll();
		List<Staff> staffs = new ArrayList<Staff>();
		
		staffPOs.forEach((po) -> {
			Staff staff = staffFactory.creatStaff(po);
			staffs.add(staff);
		});
		return staffs;
	}

}
