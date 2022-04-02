package com.customerservice.dto;

import java.io.Serializable;

import com.customerservice.domain.model.entity.OrderProfile;

public class FindOptimalStaffDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private OrderProfile order;
	private String inquire;	
	
	public FindOptimalStaffDTO(OrderProfile order, String inquire) {
		super();
		this.order = order;
		this.inquire = inquire;
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
