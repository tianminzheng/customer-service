package com.customerservice.order.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.customerservice.order.domain.model.aggregate.Order;
import com.customerservice.order.domain.respository.OrderRepository;
import com.customerservice.order.infrastructure.repository.factory.OrderFactory;
import com.customerservice.order.infrastructure.repository.mapper.OrderMapper;
import com.customerservice.order.infrastructure.repository.po.OrderPO;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private OrderMapper orderMapper;
	private OrderFactory orderFactory;

	public OrderRepositoryImpl(OrderMapper orderMapper,
			OrderFactory orderFactory) {
		this.orderMapper = orderMapper;
		this.orderFactory = orderFactory;
	}
	
	@Override
	public void save(Order order) {
		OrderPO orderPO = orderFactory.createOrderPO(order);
		orderMapper.save(orderPO);
	}

	@Override
	public Order findByOrderNumber(String orderNumber) {
		OrderPO orderPO = orderMapper.findByOrderNumber(orderNumber);
		return orderFactory.createOrder(orderPO);
	}

	@Override
	public List<Order> findAll() {
		List<OrderPO> orderPOs = orderMapper.findAll();
		List<Order> orders = new ArrayList<Order>();
		
		orderPOs.forEach((po) -> {
			Order order = orderFactory.createOrder(po);
			orders.add(order);
		});
		return orders;
	}

}
