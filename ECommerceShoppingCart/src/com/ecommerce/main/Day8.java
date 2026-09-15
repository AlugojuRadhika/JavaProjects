package com.ecommerce.main;

import java.util.ArrayList;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.util.FileUtil;

public class Day8 {

	public static void main(String[] args) {
		Product product=new Product(401,"Laptop","Electronics",66990.99,10);
		 FileUtil.saveProduct(product);
		 ArrayList<Product> products = FileUtil.readProducts();
		 ProductRepository repo = new ProductRepository();

		 for (Product product1 : products) {
		     repo.saveProduct(product1);
		 }
	}

}
