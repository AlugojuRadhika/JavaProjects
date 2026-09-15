package com.ecommerce.repository;

import java.util.ArrayList;

import com.ecommerce.model.User;

public class UserRepository {
	ArrayList<User> arrlist=new ArrayList<>();
	public User findByUserName(String username) {
		for(User user:arrlist) {
			if(user.getUserName().equals(username)) {
				return user;
			}
		}
		return null;
		
	}
	public void Save(User user) {
		arrlist.add(user);
	}
	public ArrayList<User> getAllUsers(){
		return arrlist;
	}
}
