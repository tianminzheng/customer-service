package com.customerservice.domain.event;

import com.customerservice.domain.model.valueobject.MessageSource;

public class TicketAppliedEvent extends TicketEvent{

	public TicketAppliedEvent(String ticketId, String account, String staff, MessageSource messageSource,
			String message) {
		super(ticketId, account, staff, messageSource, message);
	}

	
}
