package com.abcxyz.test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.abcxyz.CartItem;
import com.abcxyz.ShoppingCart;

class TestShoppingCart {

	
	
	
	@Test
	void addOneItem() {
		
		CartItem ci = new CartItem("SKU1",new BigDecimal(10));
		
		ShoppingCart sC = new ShoppingCart();
		
		sC.AddItem(ci, 1);
		
		int nNumItems = sC.getNumberOfItems("SKU1");
		
		assertEquals(nNumItems,1);
		
	}
	
	@Test	
	void addTwoItemRemoveOneItem() {
		
		CartItem ci1 = new CartItem("SKU1",new BigDecimal(10));
		CartItem ci2 = new CartItem("SKU2",new BigDecimal(20));
		
		ShoppingCart sC = new ShoppingCart();
		
		sC.AddItem(ci1,1);
		sC.AddItem(ci2,1);
		
		
		sC.removeItem("SKU1", 1);
		
		int nRemainingItemsSKU1 = sC.getNumberOfItems("SKU1");
		
		assertEquals(0,nRemainingItemsSKU1);
		
		int nRemainingItemsSKU2 = sC.getNumberOfItems("SKU2");
		
		assertEquals(1,nRemainingItemsSKU2);
		
	}
	
	
	@Test	
	void addFiveItemsRemoveFiveItems() {
		
		CartItem ci1 = new CartItem("SKU1",new BigDecimal(10));
		
		ShoppingCart sC = new ShoppingCart();
		
		sC.AddItem(ci1,5);
		
		int nRemainingItems = sC.removeItem("SKU1", 5);
		
		assertEquals(0,nRemainingItems);
		
	}
	
	
	
	

}
