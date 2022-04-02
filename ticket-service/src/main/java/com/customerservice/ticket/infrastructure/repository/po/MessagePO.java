package com.customerservice.ticket.infrastructure.repository.po;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.customerservice.domain.model.valueobject.MessageSource;

@Entity
@Table(name="message")
public class MessagePO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ticketId;
	private String account;
	private String staff;
	@Enumerated(EnumType.STRING)
	private MessageSource messageSource;
	private String message;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public CustomerTicketPO getTicket() {
//		return ticket;
//	}
//	public void setTicket(CustomerTicketPO ticket) {
//		this.ticket = ticket;
//	}
	public String getAccount() {
		return account;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
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
