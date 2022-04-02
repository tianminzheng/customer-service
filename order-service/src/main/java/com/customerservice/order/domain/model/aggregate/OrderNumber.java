package com.customerservice.order.domain.model.aggregate;

public class OrderNumber {

	private String orderNumber;

	public OrderNumber(String orderNumber) {
		super();
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}
}
