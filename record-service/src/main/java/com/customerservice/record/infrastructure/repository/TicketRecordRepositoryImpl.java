package com.customerservice.record.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.customerservice.record.domain.model.aggregate.TicketRecord;
import com.customerservice.record.domain.respository.TicketRecordRepository;
import com.customerservice.record.infrastructure.repository.factory.TicketRecordFactory;
import com.customerservice.record.infrastructure.repository.mapper.TicketRecordMapper;
import com.customerservice.record.infrastructure.repository.po.TicketRecordPO;

@Repository
public class TicketRecordRepositoryImpl implements TicketRecordRepository {

	private TicketRecordMapper ticketRecordMapper;
	private TicketRecordFactory ticketRecordFactory;

	public TicketRecordRepositoryImpl(TicketRecordMapper ticketRecordMapper,
			TicketRecordFactory ticketRecordFactory) {
		this.ticketRecordMapper = ticketRecordMapper;
		this.ticketRecordFactory = ticketRecordFactory;
	}
	
	@Override
	public void save(TicketRecord ticketRecord) {
		TicketRecordPO ticketRecordPO = ticketRecordFactory.creatTicketRecordPO(ticketRecord);
		ticketRecordMapper.save(ticketRecordPO);
	}

	@Override
	public List<TicketRecord> findAll() {
		List<TicketRecordPO> ticketRecordPOs = ticketRecordMapper.findAll();
		List<TicketRecord> ticketRecords = new ArrayList<TicketRecord>();
		
		ticketRecordPOs.forEach((po) -> {
			TicketRecord ticketRecord = ticketRecordFactory.creatTicketRecord(po);
			ticketRecords.add(ticketRecord);
		});
		return ticketRecords;
	}
}
