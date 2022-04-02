package com.customerservice.order.domain.model.aggregate;

import java.util.List;

import com.customerservice.order.domain.command.CreateOrderCommand;
import com.customerservice.order.domain.model.entity.Goods;

public class Order {

	private OrderNumber orderNumber;
	private String account;
	private String deliveryAddress;
	private List<Goods> goods;

	public Order() {
		
	}
	
	public Order(CreateOrderCommand createOrderCommand) {
		
	}

	public OrderNumber getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(OrderNumber orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
}
