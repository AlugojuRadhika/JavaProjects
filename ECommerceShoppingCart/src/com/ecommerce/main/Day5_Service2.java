package com.ecommerce.main;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

public class Day5_Service2 {

	public static void main(String[] args) throws Exception {
		ProductService prod_service = new ProductService();
		Product product = new Product(10, "laptop", "Electronics", 55000.00, 10);
		prod_service.addProduct(product);
		Product product1 = new Product(5, "Mobile", "Electronics", 55000.00, 10);
		prod_service.addProduct(product1);
//		try { //duplicate exception
//		Product product2 = new Product(5, "laptop", "Electronics", 55000.00, 10);
//		prod_service.addProduct(product2);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		prod_service.viewAllProducts();
		System.out.println(prod_service.findProduct(10));
		try { //InvalidProductException
			Product product3 = new Product(-1, "Laptop", "Electronic", 55000, 10); //1
			Product product4 = new Product(20, "Laptop", "Electronic", -55000, 10); //2
			Product product5 = new Product(20, "Laptop", "Electronic", 55000, -10); //3
			Product product6 = new Product(20, "Laptop", "Electronic", 55000, 0);
//			prod_service.addProduct(product3); //1
//			prod_service.addProduct(product4); //2
//			prod_service.addProduct(product5); //3
			prod_service.addProduct(product6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		deleteProduct
//		prod_service.deleteProduct(10);
		try {
			prod_service.deleteProduct(100);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Product is not available we can't delete");
		}
//		prod_service.viewAllProducts();
		prod_service.searchByName("laptop");
		try {
//		    prod_service.updateProduct(10, "", "Electronics", 55000, 10); //1
			prod_service.updateProduct(1, "phone", "", 55000, 10);
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		prod_service.updateProduct(
			    10,
			    "Gaming Laptop",
			    "Electronics",
			    65000,
			    8
			);

			System.out.println(prod_service.findProduct(10));
	}

}
