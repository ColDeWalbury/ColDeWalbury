package com.abcxyz;

import java.math.BigDecimal;

public class CartItem {
	
	
	
	public String getSku() {
		return sku;
	}



	public void setSku(String name) {
		this.sku = name;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	String sku;
	BigDecimal price;
	
	
	
	public CartItem(String name, BigDecimal price)
	{
		this.sku = name;
		this.price = price;
	}

}


