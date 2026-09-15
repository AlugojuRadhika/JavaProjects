package com.ecommerce.main;

import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.CartService;
import com.ecommerce.service.ProductService;

public class Day6 {

	public static void main(String[] args) throws Exception {
		ProductRepository prod_repo=new ProductRepository();
		Product product=new Product(101, "Laptop", "Electronic", 55000.00, 10);
		prod_repo.saveProduct(product);
		Product product2 = new Product(102, "Mouse", "Electronic", 800.00, 20);
		prod_repo.saveProduct(product2);
		ProductService prod_service=new ProductService(prod_repo);
		Product found_product = prod_service.findProduct(101);
		System.out.println(found_product);
		Product found_product1 = prod_service.findProduct(102);
		System.out.println(found_product1);
//		System.out.println(prod_service.findProduct(101));
//		System.out.println(prod_service.findProduct(102));
		try {
			System.out.println(prod_service.findProduct(1000));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
//		CartItem cart_item=new CartItem(product,2);
		CartItem cart_item = new CartItem(found_product1, 2);
		CartService cart_service=new CartService(prod_repo);
		
		cart_service.addToCart(cart_item);
		cart_service.viewCart();
		System.out.println(cart_service.calculateTotal());
		System.out.println("After clear");
		cart_service.clearCart();
		cart_service.viewCart();
		System.out.println(cart_service.calculateTotal());
		
		
		
	}

}
