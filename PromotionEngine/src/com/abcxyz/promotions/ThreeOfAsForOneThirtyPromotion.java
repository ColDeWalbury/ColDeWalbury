package com.abcxyz.promotions;

import java.math.BigDecimal;

import com.abcxyz.ShoppingCart;

public class ThreeOfAsForOneThirtyPromotion implements Promotion {

	@Override
	public String getDescription() {
		return "If you buy 3 A's, it only costs 130";
	}

	
	@Override
	public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {
		
		
		int nNumberOfAs = shoppingCart.getNumberOfItems("A");
		
		if (nNumberOfAs==0) return BigDecimal.ZERO;
		
		int nNumberOfDiscounts = nNumberOfAs/3;
		
		int nNumberOfNonDiscountedItems = nNumberOfAs%3;
		
		BigDecimal nUnitPrice = shoppingCart.getUnitPrice("A");
		
		BigDecimal nDiscountedPrice = (new BigDecimal(nNumberOfDiscounts).multiply(new BigDecimal(130))).add((nUnitPrice.multiply(new BigDecimal(nNumberOfNonDiscountedItems))));
		
		BigDecimal nPreDiscountedPrice = new BigDecimal(nNumberOfAs).multiply(nUnitPrice);
		
		
		if(nPreDiscountedPrice.compareTo(nDiscountedPrice)==1)
		{
			return nPreDiscountedPrice.subtract(nDiscountedPrice);
		}
		
		return BigDecimal.ZERO;
	}

}
