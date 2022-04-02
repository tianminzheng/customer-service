package com.customerservice.ticket.domain.model.aggregate;

/**
 * CustomerTicket聚合的聚合标识符
 */
public class TicketId {

	private String ticketId;

	public TicketId() {
		super();
	}
	
	public TicketId(String ticketId) {
		super();
		this.ticketId = ticketId;
	}

	public String getTicketId() {
		return ticketId;
	}		
}
