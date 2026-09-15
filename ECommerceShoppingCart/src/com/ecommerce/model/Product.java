package com.ecommerce.model;

public class Product {
	private int productId;
	private String productName;
	private String productCategory;
	private double productPrice;
	private int productStock;

	public Product(int productId, String productName, String productCategory, double productPrice,
			int productStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productStock=" + productStock + "]";
	}

}
