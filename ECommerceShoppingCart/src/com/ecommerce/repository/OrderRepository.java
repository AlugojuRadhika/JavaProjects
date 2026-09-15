package com.ecommerce.repository;

import java.util.ArrayList;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;

public class OrderRepository {
	ArrayList<Order> order_list=new ArrayList<>();
	public void saveOrder(Order order) {
		order_list.add(order);
	}
	public Order findOrderById(int orderId) {
		for(int i=0;i<order_list.size();i++) {
			if(order_list.get(i).getOrderId()==orderId) {
				return order_list.get(i);
			}
		}
		return null;
	}
	public ArrayList<Order> getAllOrders(){
		return order_list;
	}
	public ArrayList<Order> getOrdersByUser(User user) {
		ArrayList<Order> result = new ArrayList<>();
		for(int i=0;i<order_list.size();i++) {
			if(order_list.get(i).getUser()==user) {
				result.add(order_list.get(i));
			}
		}
		return result;
	}
}
