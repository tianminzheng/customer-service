package com.customerservice.order.infrastructure.repository.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.order.domain.model.aggregate.Order;
import com.customerservice.order.domain.model.aggregate.OrderNumber;
import com.customerservice.order.domain.model.entity.Goods;
import com.customerservice.order.infrastructure.repository.po.GoodsPO;
import com.customerservice.order.infrastructure.repository.po.OrderPO;

@Service
public class OrderFactory {

	 public OrderPO createOrderPO(Order order){
		 OrderPO orderPO = new OrderPO();
		 orderPO.setOrderNumber(order.getOrderNumber().getOrderNumber());
		 orderPO.setAccount(order.getAccount());
		 orderPO.setDeliveryAddress(order.getDeliveryAddress());
		 
		 //
		 
		 return orderPO;
	 }
	 
	 public Order createOrder(OrderPO orderPO){
		 Order order = new Order();
		 order.setOrderNumber(new OrderNumber(orderPO.getOrderNumber()));
		 order.setAccount(orderPO.getAccount());
		 order.setDeliveryAddress(orderPO.getDeliveryAddress());
		 
		 List<Goods> goodsList = new ArrayList<Goods>();
		 for(GoodsPO goodsPO : orderPO.getGoods()) {
			 goodsList.add(convertGoods(goodsPO));
		 }
		 order.setGoods(goodsList);
		 
		 return order;
	 }
	 
	 private GoodsPO convertGoodsPO(Goods goods) {
		 return new GoodsPO(goods.getGoodsCode(), goods.getGoodsName(), goods.getPrice());
	 }
	 
	 private Goods convertGoods(GoodsPO goodsPO) {
		 return new Goods(goodsPO.getGoodsCode(), goodsPO.getGoodsName(), goodsPO.getPrice());
	 }
}
