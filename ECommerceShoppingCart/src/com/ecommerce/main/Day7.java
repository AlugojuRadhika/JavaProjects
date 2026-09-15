package com.ecommerce.main;

import java.util.Scanner;

import com.ecommerce.interfacepackage.CardPayment;
import com.ecommerce.interfacepackage.Payment;
import com.ecommerce.interfacepackage.UPIPayment;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.OrderService;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;

public class Day7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductRepository prod_repo=new ProductRepository();
		Product product = new Product(202,"computer","Electronic",60000.00,5);
		User user = new User(1, "Anu", "1234", "Customer");
		prod_repo.saveProduct(product);
		CartService cart_service=new CartService(prod_repo);
		CartItem cart_item=new CartItem(product,3);
		cart_service.addToCart(cart_item);
		OrderRepository order_repo=new OrderRepository();
		OrderService order_service=new OrderService(order_repo,cart_service);
		double totalAmount=cart_service.calculateTotal();
		System.out.println("Choose the Payment Mode");
		System.out.println("1.UPI");
		System.out.println("2.CARD");
		int choice = sc.nextInt();
		Payment payment;
		switch (choice) {
		case 1 -> {
			payment = new UPIPayment();
			payment.processPayment();
		}
		case 2 -> {
			payment = new CardPayment();
			payment.processPayment();
		}
		default -> {
			System.out.println("Invalid payment mode");
			return;
		}
		}
	}

}
