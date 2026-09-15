package com.ecommerce.main;
import com.ecommerce.exception.DuplicateUserException;
import com.ecommerce.exception.InvalidCredentialsException;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

public class Day4 {

	public static void main(String[] args) throws DuplicateUserException, InvalidCredentialsException {
		User user=new User(1,"Anu","1234","Student");
		UserService user_service=new UserService();
		user_service.register(user);
//		System.out.println("Registered Successfully!!!");
		user_service.login("Anu", "1234");
		user_service.register(user);
		System.out.println("Registered Successfully!!!");
	}

}
