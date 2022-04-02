package com.customerservice.ticket.interfaces.rest.dto;

public class ApplyTicketDTO {

	private String account;
	private String orderNumber;
	private String inquire;
	
	public ApplyTicketDTO(String account, String orderNumber, String inquire) {
		super();
		this.account = account;
		this.orderNumber = orderNumber;
		this.inquire = inquire;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getInquire() {
		return inquire;
	}
	public void setInquire(String inquire) {
		this.inquire = inquire;
	}
}
