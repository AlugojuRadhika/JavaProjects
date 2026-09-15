package com.ecommerce.main;

import com.ecommerce.exception.DuplicateProductException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;

public class Day5 {

	public static void main(String[] args) throws DuplicateProductException {
		ProductRepository product_repo = new ProductRepository();
		Product product = new Product(101, "Laptop", "Electronic", 55000.00, 10); //1
		product_repo.saveProduct(product); //1
		System.out.println(product_repo.getAllProducts()); //1
	}

}
