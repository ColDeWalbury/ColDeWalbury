package com.abcxyz.promotions;

import java.math.BigDecimal;

import com.abcxyz.ShoppingCart;

public interface Promotion {
	
	public String getDescription();
	
	public BigDecimal calculateDiscount(ShoppingCart shoppingCart);
	
}
