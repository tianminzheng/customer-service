package com.customerservice.staff.infrastructure.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.staff.infrastructure.repository.po.StaffPO;

@Repository
public interface StaffMapper extends JpaRepository<StaffPO, Long>  {
	
	StaffPO findByStaffId(String staffId);
}
