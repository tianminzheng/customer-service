package com.customerservice.record.interfaces.event.assembler;

import com.customerservice.domain.event.DomainEvent;
import com.customerservice.domain.event.TicketEvent;
import com.customerservice.domain.model.valueobject.MessageSource;
import com.customerservice.record.domain.command.SaveRecordCommand;

public class SaveRecordCommandEventAssembler {

	public static SaveRecordCommand toCommandFromEvent(DomainEvent domainEvent) {
		
		TicketEvent ticketEvent = (TicketEvent)domainEvent;

		String ticketId = ticketEvent.getTicketId();
		String account = ticketEvent.getAccount();
		String staff = ticketEvent.getStaff();
		MessageSource messageSource = ticketEvent.getMessageSource();
		String message = ticketEvent.getMessage();
						
		return new SaveRecordCommand(ticketId, account, staff, messageSource, message);
	}
}
