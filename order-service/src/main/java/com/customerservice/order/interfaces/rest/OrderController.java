package com.customerservice.order.interfaces.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.domain.model.valueobject.GoodsProfile;
import com.customerservice.order.application.commandservice.OrderCommandService;
import com.customerservice.order.application.queryservice.OrderQueryService;
import com.customerservice.order.domain.command.CreateOrderCommand;
import com.customerservice.order.domain.model.aggregate.Order;
import com.customerservice.order.domain.model.entity.Goods;
import com.customerservice.order.interfaces.rest.assembler.CreateOrderCommandDTOAssembler;
import com.customerservice.order.interfaces.rest.dto.CreateOrderDTO;


@RestController
@RequestMapping(value = "orders")
public class OrderController {

	private OrderCommandService orderCommandService;
	private OrderQueryService orderQueryService;

	public OrderController(OrderCommandService orderCommandService,
			OrderQueryService orderQueryService) {
		this.orderCommandService = orderCommandService;
		this.orderQueryService = orderQueryService;
	}
	
	@GetMapping(value = "/{orderNumber}")
	public Order getOrderByOrderNumber(@PathVariable String orderNumber) {
		Order order = orderQueryService.findByOrderNumber(orderNumber);
		return order;
	}
	
	@GetMapping(value = "/profile/{orderNumber}")
	public OrderProfile getOrderProfileByOrderNumber(@PathVariable String orderNumber) {
		Order order = orderQueryService.findByOrderNumber(orderNumber);
		
		//将Order转换为OrderProfile
		List<GoodsProfile> goodsProfiles = new ArrayList<GoodsProfile>();
		for(Goods goods : order.getGoods()) {
			goodsProfiles.add(new GoodsProfile(goods.getGoodsCode(), goods.getGoodsName(), goods.getPrice()));
		}
		
		return new OrderProfile(order.getOrderNumber().getOrderNumber(), order.getDeliveryAddress(), goodsProfiles);
	}
	
	@PostMapping(value = "/")
	public void createOrder(@RequestBody CreateOrderDTO createPlanDTO) {
		
		CreateOrderCommand createPlanCommand = CreateOrderCommandDTOAssembler.toCommandFromDTO(createPlanDTO);
		orderCommandService.handleOrderCreation(createPlanCommand);
	}
	
	@GetMapping(value = "/list")
	public List<Order> getOrders() {
		 
		return orderQueryService.findAll();
	}
	
}
