package com.abcxyz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;


public class ShoppingCart {
	
	BigDecimal totalPrice;
	BigDecimal totalPriceIncDiscounts;
	
	ArrayList<CartItem> items;
	HashMap<String,Integer> numItems;

	public ShoppingCart()
	{
		items=new ArrayList<CartItem>();
		numItems = new HashMap<String,Integer>();
		totalPrice = new BigDecimal(0);
		totalPriceIncDiscounts = new BigDecimal(0);		
	}
	
	
	private void UpdateTotalPrice(BigDecimal itemPrice)
	{
		totalPrice=totalPrice.add(itemPrice);
	}
	
	
	public BigDecimal getTotalPrice()
	{
		return totalPrice;
	}
	
	
	public BigDecimal getTotalPriceIncDiscounts()
	{
		return totalPriceIncDiscounts;
	}
	
	
	
	public void setTotalPriceIncDiscounts(BigDecimal totalPriceIncDiscounts)
	{
		this.totalPriceIncDiscounts=totalPriceIncDiscounts;
	}
	
	
	public Integer AddItem(CartItem cartItem, Integer nItemsToAdd)
	{
		
		if(nItemsToAdd==0)
		{
			return getNumberOfItems(cartItem.getSku());
		}
		
		items.add(cartItem);
		
		UpdateTotalPrice(cartItem.getPrice().multiply(new BigDecimal(nItemsToAdd)));
				
		if(numItems.get(cartItem.getSku()) != null)
		{
			numItems.put(cartItem.getSku(), numItems.get(cartItem.getSku()) + nItemsToAdd);
			return getNumberOfItems(cartItem.getSku());
		}  
		else
		{
			numItems.put(cartItem.getSku(),nItemsToAdd);
			return getNumberOfItems(cartItem.getSku());
		}
		
	}
	
	
	public Integer removeItem(String sKu, Integer nItemsToRemove)
	{
		
		int nItems = items.size();
		
		
		for(int i = 0;i< nItems;i++)
		{
			
			CartItem cI = items.get(i);
			if(cI.getSku().equals(sKu)==true)
			{
				
				Integer nRemoveableItems = getNumberOfItems(sKu);
				
				Integer newTotal = 0;
				
				if(nRemoveableItems.compareTo(nItemsToRemove)>0)
				{
					newTotal=nRemoveableItems-nItemsToRemove;
				}
				
				
				if(newTotal<1)
				{
					items.remove(i);
					numItems.remove(sKu);
					return 0;
				}
				numItems.put(sKu, newTotal);
				
				return newTotal;
			}
			
		}
		
		return null;
	}

	
	
	
	public Integer removeItem(CartItem cartItem, Integer nItemsToRemove)
	{
		return removeItem(cartItem.getSku(),nItemsToRemove);
	}
		
	
	
	
	public Integer getNumberOfItems(String sKU)
	{
		if(numItems.get(sKU) != null)
		{
			return numItems.get(sKU);
		}
		
		return 0;
	}
	
	
	
	public BigDecimal getUnitPrice(String sKU)
	{
		int nItems = items.size();
		
		for(int i = 0;i< nItems;i++)
		{
			CartItem cI = items.get(i);
			if(cI.getSku().equals(sKU)==true)
			{
				return cI.getPrice();
			}
		}
		
		return null;
	}
	
	
	
	
}

