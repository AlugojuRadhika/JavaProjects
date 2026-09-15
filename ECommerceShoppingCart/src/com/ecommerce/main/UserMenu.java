package com.ecommerce.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.ecommerce.model.CartItem;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.CartService;
import com.ecommerce.service.OrderService;
import com.ecommerce.util.DataStore;
import com.ecommerce.util.InputUtil;

public class UserMenu {

	public static void main(String[] args) {
//		ProductRepository prod_repo = new ProductRepository();
		ProductRepository prod_repo = DataStore.prod_repo;
		OrderRepository order_repo = DataStore.order_repo;
		Product product1 = new Product(101, "Laptop", "Electronic", 55000, 10);
		Product product2 = new Product(102, "Mobile", "Electronic", 25000, 15);

		prod_repo.saveProduct(product1);
		prod_repo.saveProduct(product2);
		CartService cart_service = new CartService(prod_repo);
		CartItem cart_item = new CartItem(product1, 5);
//		OrderRepository order_repo = new OrderRepository();
		OrderService order_service = new OrderService(order_repo, cart_service);
		User user = new User("Aruna", "12345", "Teacher");
		int choice;
		do {
			System.out.println();
			System.out.println("========== USER MENU ==========");
			System.out.println("1. View Products");
			System.out.println("2. Search Product");
			System.out.println("3. Add To Cart");
			System.out.println("4. View Cart");
			System.out.println("5. Update Cart");
			System.out.println("6. Remove From Cart");
			System.out.println("7. Checkout");
			System.out.println("8. View My Orders");
			System.out.println("9. Logout");
			System.out.println("===============================");
			System.out.print("Enter your choice: ");
			choice = InputUtil.readInt();
			switch (choice) {
			case 1:
				System.out.println("View Products selected");
				for (Product product : prod_repo.getAllProducts()) {
					System.out.println(product);
				}

				break;
			case 2:
				System.out.println("Search Product selected");
				System.out.print("Enter product name to search: ");
				String name = InputUtil.readString();
				ArrayList<Product> result = prod_repo.searchByName(name);
				if (result.isEmpty()) {
					System.out.println("Product not found!");
				} else {
					for (Product product : result) {
						System.out.println(product);
					}
				}
				break;
			case 3:
			    System.out.println("Add To Cart selected");

			    System.out.print("Enter product ID: ");
			    int productId = InputUtil.readInt();

			    Product product = prod_repo.findByProductId(productId);

			    if (product == null) {
			        System.out.println("Product not found!");
			        break;
			    }

			    System.out.println("Product found: " + product);

			    System.out.print("Enter quantity: ");
			    int quantity = InputUtil.readInt();

			    if (quantity <= 0) {
			        System.out.println("Quantity must be greater than 0!");
			        break;
			    }

			    if (quantity > product.getProductStock()) {
			        System.out.println("Insufficient stock!");
			        break;
			    }

			    CartItem cartItem = new CartItem(product, quantity);

			    cart_service.addToCart(cartItem);

			    System.out.println(product.getProductName() + " x " + quantity + " added to cart successfully!");

			    break;
			case 4:
				System.out.println("View Cart selected");

			    if (cart_service.getCartItems().isEmpty()) {
			        System.out.println("Your cart is empty!");
			    } else {
			        System.out.println("========== YOUR CART ==========");
			        cart_service.viewCart();
			        System.out.println("===============================");
			    }
			    break;
			case 5:
				System.out.println("Update Cart selected");

			    System.out.print("Enter product ID: ");
			    int updateProductId = InputUtil.readInt();

			    System.out.print("Enter new quantity: ");
			    int newQuantity = InputUtil.readInt();

			    cart_service.changeQuantity(updateProductId, newQuantity);
			    break;
			case 6:
				System.out.println("Remove From Cart selected");

			    System.out.print("Enter product ID: ");
			    int removeProductId = InputUtil.readInt();

			    cart_service.removeFromCart(removeProductId);
			    break;
			case 7:
				System.out.println("Checkout selected");
				order_service.checkOut(user);
				break;
			case 8:
				System.out.println("View My Orders selected");

			    ArrayList<Order> orders = order_service.getOrdersByUser(user);

			    if (orders.isEmpty()) {
			        System.out.println("You have no orders yet.");
			    } else {
			        System.out.println("========== MY ORDERS ==========");
			        for (Order order : orders) {
			            System.out.println(order);
			        }
			        System.out.println("===============================");
			    }
				break;
			case 9:
				System.out.println("Logged out successfully!");
				return;
			default:
				System.out.println("Invalid choice! Please select 1 to 9.");
			}
		} while (choice != 9);
	}
}