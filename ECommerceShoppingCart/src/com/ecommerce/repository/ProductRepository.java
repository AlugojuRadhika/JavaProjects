package com.ecommerce.repository;

import java.util.ArrayList;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;

public class ProductRepository {
	ArrayList<Product> arrlist = new ArrayList<>();
	public void saveProduct(Product product) {
		arrlist.add(product);
	}
	public Product findByProductId(int productId) {
		for(Product product:arrlist) {
//			System.out.println(product.getProductId());
			if(product.getProductId()==productId) {
				return product;
			}
		}
		return null;
		
	}
	public ArrayList<Product> getAllProducts(){
		return arrlist;
	}
	public void updateProduct(Product product) {
		for(int i=0;i<arrlist.size();i++) {
			if(arrlist.get(i).getProductId()==product.getProductId()) {
				arrlist.set(i, product);
				return;
			}
		}
	}
	public void deleteProduct(int productId) {
		for(int i=0;i<arrlist.size();i++) {
			if(arrlist.get(i).getProductId()==productId) {
				arrlist.remove(i);
				return;
			}
		}
	}
	public ArrayList<Product> searchByName(String name){
		ArrayList<Product> result=new ArrayList<>();
		for(Product product:arrlist) {
			if(product.getProductName().toLowerCase().contains(name.toLowerCase())) {
				result.add(product);
			}
			
		}
		return result;
	}
}
