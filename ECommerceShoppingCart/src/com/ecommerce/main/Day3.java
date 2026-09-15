package com.ecommerce.main;

import com.ecommerce.exception.InsufficientStockException;

public class Day3 {

	public static void main(String[] args) throws Exception {
		int AvailableStock=3;
		int RequestedQuantity=8;
		try {
			if(RequestedQuantity>AvailableStock) {
				throw new InsufficientStockException("Only "+AvailableStock+" items are available");
			}
		}catch(Exception e) {
			System.out.println("Insufficient Stock: "+e.getMessage());
		}
		System.out.println(AvailableStock);
		System.out.println(RequestedQuantity);
	}

}
