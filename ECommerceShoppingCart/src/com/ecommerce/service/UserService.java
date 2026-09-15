package com.ecommerce.service;

import com.ecommerce.exception.DuplicateUserException;
import com.ecommerce.exception.InvalidCredentialsException;
import com.ecommerce.model.User;
//import java.util.ArrayList;
//
//import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

public class UserService {
//	private ArrayList<User> al;
	UserRepository userRepository;
	public UserService(UserRepository userRepository) {
	    this.userRepository = userRepository;
	}

	public void register(User user) throws DuplicateUserException{
		User existingUser=userRepository.findByUserName(user.getUserName());
		if(existingUser!=null) {
			throw new DuplicateUserException("Username already exists!");
		}
		userRepository.Save(user);
		System.out.println("Registered Successfully!!!");
	}

	public User login(String username,String password) throws InvalidCredentialsException {
		User find_user=userRepository.findByUserName(username);
	if(find_user==null || !find_user.getPassword().equals(password)){
		throw new InvalidCredentialsException("Invalid username or password");
	}
	System.out.println("Login Successfully!!!");
	return find_user;
}
}
