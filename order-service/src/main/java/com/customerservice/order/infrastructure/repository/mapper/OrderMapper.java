package com.customerservice.order.infrastructure.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.order.infrastructure.repository.po.OrderPO;

@Repository
public interface OrderMapper extends JpaRepository<OrderPO, Long>  {
	
	OrderPO findByOrderNumber(String orderNumber);
}
