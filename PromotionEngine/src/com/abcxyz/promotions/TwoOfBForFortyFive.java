package com.abcxyz.promotions;

import java.math.BigDecimal;

import com.abcxyz.ShoppingCart;




public class TwoOfBForFortyFive implements Promotion {

	@Override
	public String getDescription() {
		return "If you buy 2 B's, it only costs 45";
	}

	
	@Override
	public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {
		
		
		int nNumberOfBs = shoppingCart.getNumberOfItems("B");
		
		if (nNumberOfBs==0) return BigDecimal.ZERO;
		
		int nNumberOfDiscounts = nNumberOfBs/2;
		
		int nNumberOfNonDiscountedItems = nNumberOfBs%2;
		
		BigDecimal nUnitPrice = shoppingCart.getUnitPrice("B");
		
		BigDecimal nDiscountedPrice = (new BigDecimal(nNumberOfDiscounts).multiply(new BigDecimal(45))).add((nUnitPrice.multiply(new BigDecimal(nNumberOfNonDiscountedItems))));
		
		BigDecimal nPreDiscountedPrice = new BigDecimal(nNumberOfBs).multiply(nUnitPrice);
		
		
		if(nPreDiscountedPrice.compareTo(nDiscountedPrice)==1)
		{
			return nPreDiscountedPrice.subtract(nDiscountedPrice);
		}
		
		return BigDecimal.ZERO;
	}

}
