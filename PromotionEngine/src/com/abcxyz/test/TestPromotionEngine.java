package com.abcxyz.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.abcxyz.CartItem;
import com.abcxyz.PromotionEngine;
import com.abcxyz.ShoppingCart;
import com.abcxyz.promotions.CPlusDFOrThirtyPromotion;
import com.abcxyz.promotions.ThreeOfAsForOneThirtyPromotion;
import com.abcxyz.promotions.TwoOfBForFortyFive;

class TestPromotionEngine {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void scenarioA() {
		
		CartItem cartItemA1 = new CartItem("A",new BigDecimal(50));
		
		CartItem cartItemB1 = new CartItem("B",new BigDecimal(30));
		
		CartItem cartItemC1 = new CartItem("C",new BigDecimal(20));
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.AddItem(cartItemA1,1);
		
		cart.AddItem(cartItemB1,1);
		
		cart.AddItem(cartItemC1,1);
		
		ThreeOfAsForOneThirtyPromotion promotion1 = new ThreeOfAsForOneThirtyPromotion();
		
		TwoOfBForFortyFive promotion2 = new TwoOfBForFortyFive();
		
		CPlusDFOrThirtyPromotion promotion3 = new CPlusDFOrThirtyPromotion();
		
		PromotionEngine pE = new PromotionEngine();
		
		pE.AddPromotion(promotion1);
		
		pE.AddPromotion(promotion2);
		
		pE.AddPromotion(promotion3);
		
		cart = pE.ApplyPromotions(cart);
		
		BigDecimal totalPriceIncDiscounts = cart.getTotalPriceIncDiscounts();
		
		assertEquals(new BigDecimal(100), totalPriceIncDiscounts);
		
		assertTrue(true);
		
		
		
	}
	
	
	@Test
	void scenarioB() {
		
		CartItem cartItemA1 = new CartItem("A",new BigDecimal(50));
			
		CartItem cartItemB1 = new CartItem("B",new BigDecimal(30));
		
		CartItem cartItemC1 = new CartItem("C",new BigDecimal(20));
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.AddItem(cartItemA1,5);
		
		cart.AddItem(cartItemB1,5);
				
		cart.AddItem(cartItemC1,1);
		
		ThreeOfAsForOneThirtyPromotion promotion1 = new ThreeOfAsForOneThirtyPromotion();
		
		TwoOfBForFortyFive promotion2 = new TwoOfBForFortyFive();
		
		CPlusDFOrThirtyPromotion promotion3 = new CPlusDFOrThirtyPromotion();
		
		PromotionEngine pE = new PromotionEngine();
		
		pE.AddPromotion(promotion1);
		
		pE.AddPromotion(promotion2);
		
		pE.AddPromotion(promotion3);
		
		cart = pE.ApplyPromotions(cart);
		
		BigDecimal totalPriceIncDiscounts = cart.getTotalPriceIncDiscounts();
		
		assertEquals(new BigDecimal(370), totalPriceIncDiscounts);
			
		
	}	
	
	
	@Test
	void scenarioC() {
		
		CartItem cartItemA1 = new CartItem("A",new BigDecimal(50));
		
		CartItem cartItemB1 = new CartItem("B",new BigDecimal(30));
		
		CartItem cartItemC1 = new CartItem("C",new BigDecimal(20));
		
		CartItem cartItemD1 = new CartItem("D",new BigDecimal(15));
		
		
		ShoppingCart cart = new ShoppingCart();
		
		cart.AddItem(cartItemA1,3);
		
		cart.AddItem(cartItemB1,5);
		
		cart.AddItem(cartItemC1,1);
				
		cart.AddItem(cartItemD1,1);
		
		ThreeOfAsForOneThirtyPromotion promotion1 = new ThreeOfAsForOneThirtyPromotion();
		
		TwoOfBForFortyFive promotion2 = new TwoOfBForFortyFive();
		
		CPlusDFOrThirtyPromotion promotion3 = new CPlusDFOrThirtyPromotion();
		
		PromotionEngine pE = new PromotionEngine();
		
		pE.AddPromotion(promotion1);
		
		pE.AddPromotion(promotion2);
		
		pE.AddPromotion(promotion3);
		
		cart = pE.ApplyPromotions(cart);
		
		cart.getTotalPriceIncDiscounts();
		
		BigDecimal totalPriceIncDiscounts = cart.getTotalPriceIncDiscounts();
		
		assertEquals(new BigDecimal(280), totalPriceIncDiscounts);
			
		
	}		

}
