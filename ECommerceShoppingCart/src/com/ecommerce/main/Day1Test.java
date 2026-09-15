package com.ecommerce.main;

import com.ecommerce.model.User;
import com.ecommerce.interfacepackage.CardPayment;
import com.ecommerce.interfacepackage.Payment;
import com.ecommerce.interfacepackage.UPIPayment;
import com.ecommerce.model.Product;

public class Day1Test {

	public static void main(String[] args) {
		User user = new User(1, "Indraja", "Indraja", "Student");
		Product product = new Product(2, "Mounika", "Student", 200.00, 2);
//		System.out.println(user); //1
//		System.out.println(user.getUserId()); //1
//		System.out.println(user.getUserName()); //1
//		user.setUserName("Anu"); //2
//		System.out.println(user); //2
//		System.out.println(product.getProductId()); //3
//		System.out.println(product.getProductName()); //3
//		product.setProductName("Anu"); //4
//		System.out.println(product); //4
		Payment payment1=new UPIPayment(); //5
		Payment payment2=new CardPayment(); //6
		payment1.processPayment(); //5
		payment2.processPayment(); 
	}

}
