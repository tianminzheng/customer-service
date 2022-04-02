package com.customerservice.record.domain.respository;

import java.util.List;

import com.customerservice.record.domain.model.aggregate.TicketRecord;

public interface TicketRecordRepository {

	void save(TicketRecord ticketRecord);
	
	List<TicketRecord> findAll();
}
