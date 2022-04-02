package com.customerservice.record.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.record.application.queryservice.TicketRecordQueryService;
import com.customerservice.record.domain.model.aggregate.TicketRecord;


@RestController
@RequestMapping(value = "records")
public class TicketRecordController {

	private TicketRecordQueryService ticketRecordQueryService;

	public TicketRecordController(TicketRecordQueryService ticketRecordQueryService) {
		this.ticketRecordQueryService = ticketRecordQueryService;
	}
	
	@GetMapping(value = "/list")
	public List<TicketRecord> getRecords() {
		 
		return ticketRecordQueryService.findAll();
	}
}
