package com.customerservice.record.application.commandservice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.customerservice.record.domain.command.SaveRecordCommand;
import com.customerservice.record.domain.model.aggregate.RecordId;
import com.customerservice.record.domain.model.aggregate.TicketRecord;
import com.customerservice.record.domain.respository.TicketRecordRepository;

@Service
public class TicketRecordCommandService {

	private TicketRecordRepository ticketRecordRepository;
		
	public TicketRecordCommandService(TicketRecordRepository ticketRecordRepository) {
		this.ticketRecordRepository = ticketRecordRepository;
	}

	public RecordId handleTicketRecordCreation(SaveRecordCommand saveRecordCommand) {
		
		String recordId = "Record" + UUID.randomUUID().toString().toUpperCase();
		saveRecordCommand.setRecordId(recordId);
		
		TicketRecord ticketRecord = new TicketRecord(saveRecordCommand);
		
		ticketRecordRepository.save(ticketRecord);
		
		return ticketRecord.getRecordId();
	}
}
