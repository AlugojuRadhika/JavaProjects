package com.ecommerce.main;

import java.util.Scanner;

import com.ecommerce.exception.DuplicateUserException;
import com.ecommerce.exception.InvalidCredentialsException;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import com.ecommerce.util.DataStore;
import com.ecommerce.util.InputUtil;

public class ECommerceApplication {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		User user = new User("Anu", "12345", "developer");
//		UserRepository user_repo = new UserRepository();
		UserRepository user_repo = DataStore.user_repo;
		UserService user_service = new UserService(user_repo);
		int choice = 0;

		while (choice != 3) {
			System.out.println();
			System.out.println("========== E-COMMERCE APPLICATION ==========");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("============================================");

			System.out.print("Enter your choice: ");
			choice = InputUtil.readInt();

			switch (choice) {

			case 1:
				System.out.println("Register selected");
//	                System.out.println("Enter id: ");
//	                int userId = InputUtil.readInt();
				System.out.println("Enter UserName: ");
				String username = InputUtil.readString();
				System.out.println("Enter Password: ");
				String password = InputUtil.readString();
				System.out.println("Enter Role");
				String role = InputUtil.readString();

				User user1 = new User(username, password, role);
				try {

					user_service.register(user1);

				} catch (DuplicateUserException e) {

					System.out.println(e.getMessage());
				}
				break;

			case 2:
				System.out.println("Login selected");
				System.out.println("Enter UserName: ");
				String loginUsername = InputUtil.readString();

				System.out.println("Enter Password: ");
				String loginPassword = InputUtil.readString();

				try {
					User loggedInUser =
							user_service.login(loginUsername, loginPassword);

                    System.out.println();
                    System.out.println("Welcome "
                            + loggedInUser.getUserName() + "!");

                    System.out.println("Role: "
                            + loggedInUser.getRole());

                    /*
                     * Open menu according to role
                     */

                    if (loggedInUser.getRole().equalsIgnoreCase("Admin")) {

                        System.out.println();
                        System.out.println("Opening Admin Menu...");

                        AdminMenu.main(null);

                    } else {

                        System.out.println();
                        System.out.println("Opening User Menu...");

                        UserMenu.main(null);
                    }

                } catch (InvalidCredentialsException e) {

                    System.out.println();
                    System.out.println("Login Failed!");
                    System.out.println(e.getMessage());
                }
				break;

			case 3:
				System.out.println("Thank you for using E-Commerce Application!🙏");
				break;

			default:
				System.out.println("Invalid choice! Please select 1, 2 or 3.");
			}

		}
		System.out.println("Application closed.");
		sc.close();
	}

}
