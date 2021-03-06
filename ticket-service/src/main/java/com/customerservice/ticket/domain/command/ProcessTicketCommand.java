package com.customerservice.ticket.domain.command;

import com.customerservice.domain.model.valueobject.MessageSource;

public class ProcessTicketCommand {

	private String ticketId;
	private MessageSource messageSource;
	private String message;
	
	public ProcessTicketCommand(String ticketId, MessageSource messageSource,
			String message) {
		super();
		this.ticketId = ticketId;
		this.messageSource = messageSource;
		this.message = message;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
