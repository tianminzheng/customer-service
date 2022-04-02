package com.customerservice.ticket.application.queryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.aggregate.TicketId;
import com.customerservice.ticket.domain.query.CustomerTicketSummary;
import com.customerservice.ticket.domain.query.transformer.CustomerTicketSummaryTransformer;
import com.customerservice.ticket.domain.respository.CustomerTicketRepository;

@Service
public class CustomerTicketQueryService {

	private CustomerTicketRepository customerTicketRepository;

	public CustomerTicketQueryService(CustomerTicketRepository customerTicketRepository) {

		this.customerTicketRepository = customerTicketRepository;
	}

	public CustomerTicket findByTicketId(String ticketId) {
		return customerTicketRepository.findByTicketId(ticketId);
	}
	
	public CustomerTicketSummary findSummaryByTicketId(String ticketId) {
		CustomerTicket customerTicket = customerTicketRepository.findByTicketId(ticketId);
		
		return CustomerTicketSummaryTransformer.toCustomerTicketSummary(customerTicket);
	}

	public List<CustomerTicket> findAll() {
		return customerTicketRepository.findAll();
	}

	public List<TicketId> findAllTicketIds() {
		return customerTicketRepository.findAllTicketIds();
	}

	public List<CustomerTicket> findByUserAccount(String account) {
		return customerTicketRepository.findByAccount(account);
	}	
}
