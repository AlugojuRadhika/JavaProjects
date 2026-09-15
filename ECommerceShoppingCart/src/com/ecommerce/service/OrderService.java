package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ecommerce.interfacepackage.CardPayment;
import com.ecommerce.interfacepackage.Payment;
import com.ecommerce.interfacepackage.UPIPayment;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;

public class OrderService {
	OrderRepository order_repo;
	CartService cart_service;

	public OrderService(OrderRepository order_repo, CartService cart_service) {
		this.order_repo = order_repo;
		this.cart_service = cart_service;
	}

	public void createOrder(int orderId, User user, List<CartItem> cartItems, double totalAmount, String paymentMethod,
			String status) {
		if (paymentMethod.equalsIgnoreCase("UPI") || paymentMethod.equalsIgnoreCase("CARD")
				|| paymentMethod.equalsIgnoreCase("Cash")) {
			System.out.println("Payment successfull");
			Order order = new Order(orderId, user, cartItems, totalAmount, paymentMethod, status);
			order_repo.saveOrder(order);
			cart_service.clearCart();
			System.out.println("Order created successfully");
		}else {
			System.out.println("Invalid payment method");
		}

	}

	public Order viewOrder(int orderId) {
		Order order = order_repo.findOrderById(orderId);
		return order;

	}

	public ArrayList<Order> getOrdersByUser(User user) {
		ArrayList<Order> orders = order_repo.getOrdersByUser(user);
		return orders;

	}

	public double calculateFinalTotal() {
		double total = cart_service.calculateTotal();
		return total;
	}
	public void checkOut(User user) {
		// 1. Check whether cart is empty
	    if (cart_service.getCartItems().isEmpty()) {
	        System.out.println("Your cart is empty!");
	        return;
	    }

	    // 2. Calculate total
	    double totalAmount = cart_service.calculateTotal();

	    System.out.println("Total Amount: " + totalAmount);

	    Scanner sc = new Scanner(System.in);

	    System.out.println("Choose Payment Mode");
	    System.out.println("1. UPI");
	    System.out.println("2. CARD");

	    int choice = sc.nextInt();

	    Payment payment;
	    String paymentMethod;

	    switch (choice) {

	    case 1:
	        payment = new UPIPayment();
	        paymentMethod = "UPI";
	        payment.processPayment();
	        break;

	    case 2:
	        payment = new CardPayment();
	        paymentMethod = "CARD";
	        payment.processPayment();
	        break;

	    default:
	        System.out.println("Invalid payment mode");
	        return;
	    }

	    // 3. Generate order ID
	    int orderId = order_repo.getAllOrders().size() + 1;

	    // 4. Copy cart items into the order
	    List<CartItem> orderItems =
	            new ArrayList<>(cart_service.getCartItems());

	    // 5. Create Order
	    Order order = new Order(
	            orderId,
	            user,
	            orderItems,
	            totalAmount,
	            paymentMethod,
	            "CONFIRMED"
	    );

	    // 6. Save order
	    order_repo.saveOrder(order);

	    // 7. Clear cart
	    cart_service.clearCart();

	    System.out.println();
	    System.out.println("========== ORDER SUCCESS ==========");
	    System.out.println("Order ID       : " + orderId);
	    System.out.println("Payment Method : " + paymentMethod);
	    System.out.println("Total Amount   : " + totalAmount);
	    System.out.println("Status         : CONFIRMED");
	    System.out.println("Order created successfully!");
	    System.out.println("===================================");
	}
}
