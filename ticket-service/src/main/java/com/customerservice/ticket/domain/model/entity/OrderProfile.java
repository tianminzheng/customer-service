//package com.customerservice.ticket.domain.model.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.customerservice.ticket.domain.model.valueobject.GoodsProfile;
//
//public class OrderProfile {
//
//	private String orderNumber;
//	private String deliveryAddress;
//	private List<GoodsProfile> goodsList;		
//		
//	public OrderProfile() {
//		super();
//	}
//	
//	public OrderProfile(String orderNumber) {
//		super();
//		this.orderNumber = orderNumber;
//		this.goodsList = new ArrayList<GoodsProfile>();
//	}
//
//	public OrderProfile(String orderNumber, String deliveryAddress) {
//		this(orderNumber);
//	}
//	
//	public void addGoods(GoodsProfile goods) {
//		goodsList.add(goods);
//	}
//	
//	public String getOrderNumber() {
//		return orderNumber;
//	}
//	public void setOrderNumber(String orderNumber) {
//		this.orderNumber = orderNumber;
//	}
//	public String getDeliveryAddress() {
//		return deliveryAddress;
//	}
//	public void setDeliveryAddress(String deliveryAddress) {
//		this.deliveryAddress = deliveryAddress;
//	}
//
//	public List<GoodsProfile> getGoodsList() {
//		return goodsList;
//	}
//
//	public void setGoodsList(List<GoodsProfile> goodsList) {
//		this.goodsList = goodsList;
//	}	
//}
