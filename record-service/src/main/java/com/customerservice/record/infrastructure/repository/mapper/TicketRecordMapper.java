package com.customerservice.record.infrastructure.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.record.infrastructure.repository.po.TicketRecordPO;

@Repository
public interface TicketRecordMapper extends JpaRepository<TicketRecordPO, Long>  {
	
}
