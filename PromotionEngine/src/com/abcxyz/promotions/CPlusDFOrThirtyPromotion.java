package com.abcxyz.promotions;

import java.math.BigDecimal;

import com.abcxyz.ShoppingCart;

public class CPlusDFOrThirtyPromotion implements Promotion {

	
	@Override
	public String getDescription() {
		return "If you buy C and D, it only costs 30";
	}

	
	@Override
	public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {
		
		
		int nNumberOfCs = shoppingCart.getNumberOfItems("C");
		
		
		int nNumberOfDs = shoppingCart.getNumberOfItems("D");
		
		if ((nNumberOfCs==0) || (nNumberOfDs==0)) return BigDecimal.ZERO;
		
		BigDecimal nDiscountedPrice = BigDecimal.ZERO;
		
		if(nNumberOfCs==nNumberOfDs)
		{
			nDiscountedPrice = new BigDecimal(nNumberOfCs).multiply(new BigDecimal(30));
		}
		
		BigDecimal nCUnitPrice = shoppingCart.getUnitPrice("C");
		
		
		if(nNumberOfCs>nNumberOfDs)
		{
			nDiscountedPrice = new BigDecimal(nNumberOfCs).multiply(new BigDecimal(130)).add(new BigDecimal(nNumberOfCs-nNumberOfDs).multiply(null, null));
		}
		
		BigDecimal nDUnitPrice = shoppingCart.getUnitPrice("D");
		
		
		if(nNumberOfDs>nNumberOfCs)
		{
			nDiscountedPrice = new BigDecimal(nNumberOfDs).multiply(new BigDecimal(130)).add(new BigDecimal(nNumberOfDs-nNumberOfCs).multiply(null, null));
		}
		
		
		
		
		BigDecimal nPreDiscountedPrice = (new BigDecimal(nNumberOfCs).multiply(nCUnitPrice)).add((new BigDecimal(nNumberOfDs).multiply(nDUnitPrice)));
		
		
		if(nPreDiscountedPrice.compareTo(nDiscountedPrice)==1)
		{
			return nPreDiscountedPrice.subtract(nDiscountedPrice);
		}
		
		return BigDecimal.ZERO;
	}	
	
	
	
	
	
	
	
	
}
