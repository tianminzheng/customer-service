package com.customerservice.order.application.commandservice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.customerservice.order.domain.command.CreateOrderCommand;
import com.customerservice.order.domain.model.aggregate.Order;
import com.customerservice.order.domain.model.aggregate.OrderNumber;
import com.customerservice.order.domain.respository.OrderRepository;

@Service
public class OrderCommandService {
	
	private OrderRepository orderRepository;
	
	public OrderCommandService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public OrderNumber handleOrderCreation(CreateOrderCommand createOrderCommand) {
		
		String orderNumber = "Order" + UUID.randomUUID().toString().toUpperCase();
		createOrderCommand.setOrderNumber(orderNumber);
		
		Order order = new Order(createOrderCommand);
		orderRepository.save(order);
		
		return order.getOrderNumber();

	}
}
