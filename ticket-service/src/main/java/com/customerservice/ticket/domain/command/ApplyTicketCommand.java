package com.customerservice.ticket.domain.command;

import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.domain.model.entity.StaffProfile;

public class ApplyTicketCommand {

	private String ticketId;//客服工单唯一编号	
	private String account;//用户账号
	private String orderNumber;//订单编号
	private OrderProfile order;//问询订单
	private StaffProfile staff;//客服人员
	private String inquire;//工单问询内容
	
	public ApplyTicketCommand() {
		super();
	}

	public ApplyTicketCommand(String account, String orderNumber, String inquire) {
		super();
		this.account = account;
		this.order = new OrderProfile(orderNumber);
		this.inquire = inquire;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderProfile getOrder() {
		return order;
	}

	public void setOrder(OrderProfile order) {
		this.order = order;
	}

	public StaffProfile getStaff() {
		return staff;
	}

	public void setStaff(StaffProfile staff) {
		this.staff = staff;
	}

	public String getInquire() {
		return inquire;
	}

	public void setInquire(String inquire) {
		this.inquire = inquire;
	}
}
