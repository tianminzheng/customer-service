package com.customerservice.record.infrastructure.repository.factory;

import org.springframework.stereotype.Service;

import com.customerservice.record.domain.model.aggregate.RecordId;
import com.customerservice.record.domain.model.aggregate.TicketRecord;
import com.customerservice.record.infrastructure.repository.po.TicketRecordPO;

@Service
public class TicketRecordFactory {

	 public TicketRecordPO creatTicketRecordPO(TicketRecord ticketRecord){
		 TicketRecordPO ticketRecordPO = new TicketRecordPO();
		 ticketRecordPO.setRecordId(ticketRecord.getRecordId().getRecordId());
		 ticketRecordPO.setTicketId(ticketRecord.getTicketId());
		 ticketRecordPO.setAccount(ticketRecord.getAccount());
		 ticketRecordPO.setMessage(ticketRecord.getMessage());
		 ticketRecordPO.setMessageSource(ticketRecord.getMessageSource());
		 ticketRecordPO.setStaff(ticketRecord.getStaff());
		 
		 return ticketRecordPO;
	 }
	 
	 public TicketRecord creatTicketRecord(TicketRecordPO ticketRecordPO){
		 TicketRecord ticketRecord = new TicketRecord();
		 ticketRecord.setRecordId(new RecordId(ticketRecordPO.getRecordId()));
		 ticketRecord.setTicketId(ticketRecordPO.getTicketId());
		 ticketRecord.setAccount(ticketRecordPO.getAccount());
		 ticketRecord.setMessage(ticketRecordPO.getMessage());
		 ticketRecord.setMessageSource(ticketRecordPO.getMessageSource());
		 ticketRecord.setStaff(ticketRecordPO.getStaff());
		 
		 return ticketRecord;
	 }
}
