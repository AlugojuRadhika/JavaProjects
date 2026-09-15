package com.ecommerce.service;

import java.util.ArrayList;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.model.Product;

import com.ecommerce.model.CartItem;

public class CartService {
	ArrayList<CartItem> arrlist = new ArrayList<>();
	ProductRepository produ_repo;

	public CartService(ProductRepository produ_repo) {
		this.produ_repo = produ_repo;
	}

	public void addToCart(CartItem item) {
		arrlist.add(item);
	}

	public void viewCart() {
		for (CartItem item : arrlist) {
			System.out.println(item);
		}
	}

	public void changeQuantity(int productId, int quantity) {
		for (CartItem item : arrlist) {
			if (item.getProduct().getProductId() == productId) {
				item.setQuantity(quantity);
				System.out.println("Quantity updated successfully");
				return;
			}
		}
		System.out.println("product not found in cart!");
	}

	public void removeFromCart(int productId) {
		for (int i = 0; i < arrlist.size(); i++) {
			if (arrlist.get(i).getProduct().getProductId() == productId) {
				arrlist.remove(i);
				System.out.println("Product removed from cart!");
				return;
			}
		}
		System.out.println("Product not found in cart!");
	}

	public double calculateTotal() {
		double total = 0;
		for (int i = 0; i < arrlist.size(); i++) {
			CartItem item = arrlist.get(i);
			total += item.getProduct().getProductPrice() * item.getQuantity();
		}
		return total;
	}

	public void clearCart() {
		arrlist.clear();
	}
	public ArrayList<CartItem> getCartItems() {
	    return arrlist;
	}
}
