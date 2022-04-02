package com.customerservice.ticket.domain.model.entity;

import com.customerservice.domain.model.entity.OrderProfile;

public class Consultation {

	private String consultationId;//咨询Id
	private String account;//用户账号
	private OrderProfile order;//问询订单
	private String inquire;//工单问询内容
	
	public Consultation(String consultationId, String account, OrderProfile order, String inquire) {
		super();
		this.consultationId = consultationId;
		this.account = account;
		this.order = order;
		this.inquire = inquire;
	}
	
	public String getConsultationId() {
		return consultationId;
	}
	public void setConsultationId(String consultationId) {
		this.consultationId = consultationId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public OrderProfile getOrder() {
		return order;
	}
	public void setOrder(OrderProfile order) {
		this.order = order;
	}
	public String getInquire() {
		return inquire;
	}
	public void setInquire(String inquire) {
		this.inquire = inquire;
	}
}
