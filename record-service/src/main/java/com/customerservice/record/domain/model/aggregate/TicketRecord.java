package com.customerservice.record.domain.model.aggregate;

import com.customerservice.domain.model.valueobject.MessageSource;
import com.customerservice.record.domain.command.SaveRecordCommand;

public class TicketRecord {

	private RecordId recordId;
	private String ticketId;
	private String account;
	private String staff;
	private MessageSource messageSource;
	private String message;	
	
	public TicketRecord() {
		super();
	}

	public TicketRecord(SaveRecordCommand saveRecordCommand) {
		
		this.recordId = new RecordId(saveRecordCommand.getRecordId());
		this.ticketId = saveRecordCommand.getTicketId();
		this.account = saveRecordCommand.getAccount();
		this.staff = saveRecordCommand.getStaff();
		this.messageSource = saveRecordCommand.getMessageSource();
		this.message = saveRecordCommand.getMessage();	
		
		//可以考虑发布TicketRecordedEvent事件，供其他限界上下文进行订阅和消费
	}
		
	public RecordId getRecordId() {
		return recordId;
	}
	public void setRecordId(RecordId recordId) {
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
