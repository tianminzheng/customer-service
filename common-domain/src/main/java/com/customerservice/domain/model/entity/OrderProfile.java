package com.customerservice.domain.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.customerservice.domain.model.valueobject.GoodsProfile;

public class OrderProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String orderNumber;
	private String deliveryAddress;
	private List<GoodsProfile> goodsList;	
		
	public OrderProfile() {
		super();
	}
	
	public OrderProfile(String orderNumber) {
		super();
		this.orderNumber = orderNumber;
		this.goodsList = new ArrayList<GoodsProfile>();
	}

	public OrderProfile(String orderNumber, String deliveryAddress) {
		this(orderNumber);
	}		
	
	public OrderProfile(String orderNumber, String deliveryAddress, List<GoodsProfile> goodsList) {
		super();
		this.orderNumber = orderNumber;
		this.deliveryAddress = deliveryAddress;
		this.goodsList = goodsList;
	}

	public void addGoods(GoodsProfile goods) {
		goodsList.add(goods);
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<GoodsProfile> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsProfile> goodsList) {
		this.goodsList = goodsList;
	}	
}
