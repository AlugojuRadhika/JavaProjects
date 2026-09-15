package com.ecommerce.main;

import java.util.ArrayList;

import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.util.InputUtil;
import com.ecommerce.model.*;
import com.ecommerce.util.DataStore;

public class AdminMenu {
//	public static ProductRepository prod_repo = new ProductRepository();
//
//	public static OrderRepository order_repo = new OrderRepository();
//
//	public static UserRepository user_repo = new UserRepository();

	public static void main(String[] args) throws Exception {
		ProductRepository prod_repo = DataStore.prod_repo;
		ProductService prod_service1 = new ProductService(prod_repo);
		OrderRepository order_repo = DataStore.order_repo;
		UserRepository user_repo = DataStore.user_repo;
//		Product product = new Product(202, "saree", "cloths", 63000.00, 15);
//		Product product1 = new Product(203, "saree", "cloths", 63000.00, 15);
//		Product product2 = new Product(204, "saree", "cloths", 63000.00, 15);

		int choice;

		do {

			System.out.println();
			System.out.println("========== ADMIN MENU ==========");
			System.out.println("1. Add Product");
			System.out.println("2. View Products");
			System.out.println("3. Search Product");
			System.out.println("4. Update Product");
			System.out.println("5. Delete Product");
			System.out.println("6. View Users");
			System.out.println("7. View Orders");
			System.out.println("8. Reports");
			System.out.println("9. Logout");
			System.out.println("===============================");

			System.out.print("Enter your choice: ");
			choice = InputUtil.readInt();

			switch (choice) {

			case 1:
				System.out.println();
				System.out.println("========== ADD PRODUCT ==========");
				System.out.print("Enter Product ID: ");
				int productId = InputUtil.readInt();
				System.out.print("Enter Product Name: ");
				String productName = InputUtil.readString();
				System.out.print("Enter Product Category: ");
				String category = InputUtil.readString();
				System.out.print("Enter Product Price: ");
				double price = InputUtil.readDouble();
				System.out.print("Enter Product Stock: ");
				int stock = InputUtil.readInt();
				Product product11 = new Product(productId, productName, category, price, stock);
				try {
					prod_service1.addProduct(product11);
				} catch (Exception e) {
					System.out.println("Failed to add product!");
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				System.out.println();
				System.out.println("========== ALL PRODUCTS ==========");
				if (prod_repo.getAllProducts().isEmpty()) {
					System.out.println("No products available!");
				} else {
					prod_service1.viewAllProducts();
				}
				System.out.println("==================================");
				break;

			case 3:
				System.out.println();
				System.out.println("========== SEARCH PRODUCT ==========");

				System.out.print("Enter Product ID: ");
				int searchId = InputUtil.readInt();

				try {

					Product foundProduct = prod_service1.findProduct(searchId);

					System.out.println("Product Found!");
					System.out.println(foundProduct);

				} catch (Exception e) {

					System.out.println("Product Not Found!");
					System.out.println(e.getMessage());

				}
				break;
			case 4:
				System.out.println();
				System.out.println("========== UPDATE PRODUCT ==========");
				System.out.print("Enter Product ID: ");
				int updateId = InputUtil.readInt();
				System.out.print("Enter New Product Name: ");
				String newName = InputUtil.readString();
				System.out.print("Enter New Category: ");
				String newCategory = InputUtil.readString();
				System.out.print("Enter New Price: ");
				double newPrice = InputUtil.readDouble();
				System.out.print("Enter New Stock: ");
				int newStock = InputUtil.readInt();
				try {
					prod_service1.updateProduct(updateId, newName, newCategory, newPrice, newStock);
				} catch (Exception e) {
					System.out.println("Update failed!");
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println();
				System.out.println("========== DELETE PRODUCT ==========");
				System.out.print("Enter Product ID: ");
				int deleteId = InputUtil.readInt();
				try {
					prod_service1.deleteProduct(deleteId);
					System.out.println("Product deleted successfully!");
				} catch (Exception e) {
					System.out.println("Delete failed!");
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println();
				System.out.println("========== ALL USERS ==========");
				ArrayList<User> users = user_repo.getAllUsers();
				if (users.isEmpty()) {
					System.out.println("No users registered yet!");
				} else {
					for (User user : users) {
						System.out.println(user);
					}
				}
				System.out.println("===============================");
				break;

			case 7:
				System.out.println();
				System.out.println("========== ALL ORDERS ==========");
				ArrayList<Order> orders = order_repo.getAllOrders();
				if (orders.isEmpty()) {
					System.out.println("No orders available!");
				} else {
					for (Order order : orders) {
						System.out.println(order);
					}
				}
				System.out.println("===============================");
				break;

			case 8:
				System.out.println("Reports selected");
				int totalProducts = prod_repo.getAllProducts().size();
				int totalUsers = user_repo.getAllUsers().size();
				int totalOrders = order_repo.getAllOrders().size();

				double totalSales = 0;

				for (Order order : order_repo.getAllOrders()) {
					totalSales = totalSales + order.getTotalAmount();
				}

				System.out.println("Total Products : " + totalProducts);
				System.out.println("Total Users    : " + totalUsers);
				System.out.println("Total Orders   : " + totalOrders);
				System.out.println("Total Sales    : ₹" + totalSales);

				System.out.println("=================================");
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