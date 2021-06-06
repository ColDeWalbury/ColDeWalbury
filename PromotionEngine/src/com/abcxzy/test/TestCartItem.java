package com.abcxyz.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;


import org.junit.jupiter.api.Test;

import com.abcxyz.CartItem;

class TestCartItem {

	@Test
	void retriveSKU() {
		
		CartItem ci = new CartItem("SKU1",new BigDecimal(10));
		assertEquals(ci.getSku(),new String("SKU1"));
		
	}
	
	@Test
	
	void retrievePrice() {
		
		CartItem ci = new CartItem("SKU1",new BigDecimal(10));
		assertEquals(ci.getPrice(),new BigDecimal(10));
		
	}


}
