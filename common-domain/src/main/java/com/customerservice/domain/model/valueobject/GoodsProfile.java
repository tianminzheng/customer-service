package com.customerservice.domain.model.valueobject;

import java.io.Serializable;

public class GoodsProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private String goodsCode;
	private String goodsName;
	private Float price;
	
	public GoodsProfile() {
		super();
	}

	public GoodsProfile(String goodsCode, String goodsName, Float price) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
	}
	
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}	
}
