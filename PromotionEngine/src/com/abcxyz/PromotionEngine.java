package com.abcxyz;

import java.math.BigDecimal;
import java.util.ArrayList;
import com.abcxyz.promotions.Promotion;

public class PromotionEngine {
	
	
	
	ArrayList<Promotion> promotions;
	
	
	
	public PromotionEngine()
	{
		promotions = new ArrayList<Promotion>();
	}

	
	public void AddPromotion(Promotion promotion)
	{
		promotions.add(promotion);
	}
	
	
	private BigDecimal GetPromotionAmount(ShoppingCart shoppingCart)
	{
		int nPromotions = promotions.size();
		
		BigDecimal nAmountOfDiscount = new BigDecimal(0);
		
		//BigDecimal nBiggestDiscount = new BigDecimal(0);
		
		for(int i = 0;i< nPromotions;i++)
		{
			Promotion promotion = promotions.get(i);
			
			nAmountOfDiscount=nAmountOfDiscount.add(promotion.calculateDiscount(shoppingCart));
			
			
			//Document suggests that only a single discount should be applied.  However,
			//test scenario shows multiple discounts being applied.
			
			/*
			if(nAmountOfDiscount.compareTo(nBiggestDiscount)==1)
			{
				nBiggestDiscount=nAmountOfDiscount;
			}
			*/
			
		}
		
		return nAmountOfDiscount;
		
	}
	
	
	
	public ShoppingCart ApplyPromotions(ShoppingCart shoppingCart)
	{
		BigDecimal nAmountOfDiscount = GetPromotionAmount(shoppingCart);
		
		shoppingCart.setTotalPriceIncDiscounts(shoppingCart.getTotalPrice().subtract(nAmountOfDiscount));
		
		return shoppingCart;
	}
}
