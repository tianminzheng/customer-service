package com.customerservice.ticket.domain.query;

import java.util.List;

import com.customerservice.ticket.domain.model.valueobject.Message;

public class CustomerTicketSummary {

	private String ticketId;//客服工单唯一编号
	private String orderNumber;//问询订单
	private String account;//用户账户
	private String staff;//客服人员
	private String status;//工单状态
	private List<Message> messages;//工单详细消息列表
	private int score;//工单评分	
	
	public CustomerTicketSummary() {
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
}
