package com.customerservice.ticket.domain.respository;

import java.util.List;

import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.aggregate.TicketId;

public interface CustomerTicketRepository {
	
	void save(CustomerTicket customerTicket);
	
	CustomerTicket findByTicketId(String ticketId);
	
	List<CustomerTicket> findAll();
	
	List<TicketId> findAllTicketIds();
	
	List<CustomerTicket> findByAccount(String account);
	
	void updateCustomerTicket(CustomerTicket customerTicket);

}
