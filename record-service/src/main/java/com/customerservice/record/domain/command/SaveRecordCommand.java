package com.customerservice.record.domain.command;

import com.customerservice.domain.model.valueobject.MessageSource;

public class SaveRecordCommand {

	private String recordId;	
	private String ticketId;
	private String account;
	private String staff;
	private MessageSource messageSource;
	private String message;	

	public SaveRecordCommand(String ticketId, String account, String staff, MessageSource messageSource,
			String message) {
		super();
		this.ticketId = ticketId;
		this.account = account;
		this.staff = staff;
		this.messageSource = messageSource;
		this.message = message;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
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
