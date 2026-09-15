package com.ecommerce.main;

import com.ecommerce.exception.InvalidCredentialsException;

public class Day3_Exception2 {

	public static void main(String[] args) throws InvalidCredentialsException{
		String user="Anu";
		String password="@123";
		try {
			if(!user.equals("Anu") || !password.equals("Anu@123")) {
				throw new InvalidCredentialsException("Invalid username or password");
			}
		}catch(InvalidCredentialsException e) {
			System.out.println(e.getMessage());
		}
	}

}
