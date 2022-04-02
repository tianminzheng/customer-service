package com.customerservice.ticket.domain.query.transformer;

import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.query.CustomerTicketSummary;

public class CustomerTicketSummaryTransformer {

	public static CustomerTicketSummary toCustomerTicketSummary(CustomerTicket customerTicket) {
		CustomerTicketSummary customerTicketSummary = new CustomerTicketSummary();
		customerTicketSummary.setTicketId(customerTicket.getTicketId().getTicketId());
		customerTicketSummary.setStatus(customerTicket.getStatus().toString());
		customerTicketSummary.setOrderNumber(customerTicket.getConsultation().getOrder().getOrderNumber());
		customerTicketSummary.setAccount(customerTicket.getConsultation().getAccount());
		customerTicketSummary.setStaff(customerTicket.getStaff().getStaffName());
		customerTicketSummary.setMessages(customerTicket.getMessages());
		customerTicketSummary.setScore(customerTicket.getScore().getScore());
		
		return customerTicketSummary;
	}
}
