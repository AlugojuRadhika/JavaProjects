package com.ecommerce.service;

import java.util.ArrayList;

import com.ecommerce.exception.DuplicateProductException;
import com.ecommerce.exception.InvalidProductException;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

public class ProductService {
	ProductRepository product_repo = new ProductRepository();
	public ProductService(ProductRepository product_repo) {
		this.product_repo=product_repo;
	}
	public void addProduct(Product product) throws DuplicateProductException, InvalidProductException {
		if (product.getProductId() <= 0) {
			throw new InvalidProductException("Product ID must be greater than 0");
		}
		if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
			throw new InvalidProductException("Product name cannot be empty");
		}
		if (product.getProductPrice() <= 0) {
			throw new InvalidProductException("Product price must be greater than 0");
		}
		if (product.getProductStock() < 0) {
			throw new InvalidProductException("Product stock cannot be negative");
		}
		Product existProduct = product_repo.findByProductId(product.getProductId());
		if (existProduct != null) {
			throw new DuplicateProductException("Product Already saved");
		} else {
			product_repo.saveProduct(product);
			System.out.println("Product Successfullt Saved");
		}

	}

	public void viewAllProducts() {
		ArrayList<Product> products = product_repo.getAllProducts();
		for (Product product : products) {
			System.out.println(product);
		}
	}

	public Product findProduct(int productId) throws Exception {
		Product product = product_repo.findByProductId(productId);
		if (product == null) {
			throw new ProductNotFoundException("Product Not Found!");
		}
		return product;

	}

	public void updateProduct(int productId, String name, String category, double price, int stock)
			throws ProductNotFoundException, InvalidProductException {
		Product product = product_repo.findByProductId(productId);
		if (product == null) {
			throw new ProductNotFoundException("Product Not Found");
		}
		if (category==null || category.trim().isEmpty() || name == null || name.trim().isEmpty()) {
			throw new InvalidProductException("Product name cannot be empty");
		}

		if (price <= 0) {
			throw new InvalidProductException("Product price must be greater than 0");
		}
		if (stock < 0) {
			throw new InvalidProductException("Product stock cannot be negative");
		}
		product.setProductName(name);
		product.setProductCategory(category);
		product.setProductPrice(price);
		product.setProductStock(stock);
		product_repo.updateProduct(product);
		System.out.println("product updated successfully!");
	}

	public void deleteProduct(int productId) throws ProductNotFoundException {
		Product product = product_repo.findByProductId(productId);
		if (product == null) {
			throw new ProductNotFoundException("Product Not Found");
		}
		product_repo.deleteProduct(productId);
	}

	public ArrayList<Product> searchByName(String name) {
		ArrayList<Product> result = product_repo.searchByName(name);
		return result;
	}
}
