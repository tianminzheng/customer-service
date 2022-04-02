package com.customerservice.order.domain.respository;

import java.util.List;

import com.customerservice.order.domain.model.aggregate.Order;

public interface OrderRepository {

	void save(Order order);
	
	Order findByOrderNumber(String orderNumber);
	
	List<Order> findAll();
}
