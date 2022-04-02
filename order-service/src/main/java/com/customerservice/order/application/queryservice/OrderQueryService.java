package com.customerservice.order.application.queryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.order.domain.model.aggregate.Order;
import com.customerservice.order.domain.respository.OrderRepository;

@Service
public class OrderQueryService {

	private OrderRepository orderRepository;
	
	public OrderQueryService(OrderRepository orderRepository) {

		this.orderRepository = orderRepository;
	}

	public Order findByOrderNumber(String orderNumber) {
		return orderRepository.findByOrderNumber(orderNumber);
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}
}
