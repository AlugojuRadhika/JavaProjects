package com.ecommerce.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ecommerce.model.Product;

public class FileUtil {

	public static void writeData(String data) {
		try {
			FileWriter fw = new FileWriter("products.txt", true);
			fw.write(data+ "\n");
			fw.close();
			System.out.println("Data saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Product> readProducts() {
		ArrayList<Product> arrlist = new ArrayList<>();
		try {
			
			FileReader fr = new FileReader("products.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
	            double price = Double.parseDouble(parts[3]);
	            int stock = Integer.parseInt(parts[4]);
	            Product product = new Product(
	                    id,
	                    parts[1],
	                    parts[2],
	                    price,
	                    stock
	            );

	            System.out.println(product);
	            arrlist.add(product);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrlist;
	}

	public static void saveProduct(Product product) {
		String data = product.getProductId() + "," + product.getProductName() + "," + product.getProductCategory() + ","
				+ product.getProductPrice() + "," + product.getProductStock();
		writeData(data);
	}

}
