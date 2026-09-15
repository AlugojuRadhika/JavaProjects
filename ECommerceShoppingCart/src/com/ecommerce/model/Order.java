package com.ecommerce.model;

import java.util.List;

public class Order {
	private int orderId;
	private User user;
	private List<CartItem> list;
	private double totalAmount;
	private String paymentMethod;
	private String status;

	public Order(int orderId, User user, List<CartItem> list, double totalAmount, String paymentMethod, String status) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.list = list;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public User getUser() {
		return user;
	}

	public List<CartItem> getList() {
		return list;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getpaymentMethod() {
		return paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setList(List<CartItem> list) {
		this.list = list;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setpaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", list=" + list + ", totalAmount=" + totalAmount
				+ ", status=" + status + "]";
	}

}
