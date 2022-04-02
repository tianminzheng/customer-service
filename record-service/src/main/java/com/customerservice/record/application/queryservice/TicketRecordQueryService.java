package com.customerservice.record.application.queryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.record.domain.model.aggregate.TicketRecord;
import com.customerservice.record.domain.respository.TicketRecordRepository;

@Service
public class TicketRecordQueryService {

	private TicketRecordRepository healthRecordRepository;
	
	public TicketRecordQueryService(TicketRecordRepository healthRecordRepository) {

		this.healthRecordRepository = healthRecordRepository;
	}

	public List<TicketRecord> findAll() {
		return healthRecordRepository.findAll();
	}
}
