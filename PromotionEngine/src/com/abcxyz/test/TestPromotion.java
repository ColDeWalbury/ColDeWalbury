package com.abcxyz.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.abcxyz.CartItem;
import com.abcxyz.ShoppingCart;
import com.abcxyz.promotions.CPlusDFOrThirtyPromotion;
import com.abcxyz.promotions.ThreeOfAsForOneThirtyPromotion;

class TestPromotion {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testValidThreesAsPromotion() {
		//3 As qualifies for a discount using the promotion 
		//applied in this test.  Therefore the discount is 0.
		
		
		CartItem cartItemA1 = new CartItem("A",new BigDecimal(50));
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.AddItem(cartItemA1,3);
		
		ThreeOfAsForOneThirtyPromotion promotion = new ThreeOfAsForOneThirtyPromotion();
		
		BigDecimal discount = promotion.calculateDiscount(cart);
		
		assertTrue(discount.compareTo(new BigDecimal(20))==0);
		
	}
	
	

	@Test
	void testThreesAsWithInvalidPromotion() {
		//3 As qualifies for a discount but not with the 
		//promotion applied in this test.  Therefore the discount 
		//is 0.
		
		CartItem cartItemA1 = new CartItem("A",new BigDecimal(50));
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.AddItem(cartItemA1,3);
		
		CPlusDFOrThirtyPromotion promotion = new CPlusDFOrThirtyPromotion();
		
		BigDecimal discount = promotion.calculateDiscount(cart);
		
		assertTrue(discount.compareTo(new BigDecimal(0))==0);
		
		
	}

	@Test
	void testCPlusDPromotion() {
		//C+D on promotion is 30. Without promotion price would
		//be 35.  Therefore the discount is 5.
		
		CartItem cartItemA1 = new CartItem("A",new BigDecimal(50));
		
		CartItem cartItemB1 = new CartItem("B",new BigDecimal(30));
		
		CartItem cartItemC1 = new CartItem("C",new BigDecimal(20));
		
		CartItem cartItemD1 = new CartItem("D",new BigDecimal(15));
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.AddItem(cartItemA1,1);
		
		cart.AddItem(cartItemB1,1);
		
		cart.AddItem(cartItemC1,1);
		
		cart.AddItem(cartItemD1,1);
		
		CPlusDFOrThirtyPromotion promotion = new CPlusDFOrThirtyPromotion();
		
		BigDecimal discount = promotion.calculateDiscount(cart);
		
		assertTrue(discount.compareTo(new BigDecimal(5))==0);
		
		
		
	}

	
	
	
}
