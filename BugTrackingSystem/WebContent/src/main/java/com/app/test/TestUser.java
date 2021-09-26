package com.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.beans.User;
import com.app.exceptions.EmailExistsException;
import com.app.exceptions.UserNotRegisteredException;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

public class TestUser {

	public static void main(String[] args) {
		UserService uService = new UserServiceImpl();
		List<User> uList = new ArrayList<>();
		uList.add(new User("ABC", "Tester", "abc@domain.com"));
		uList.add(new User("EFG", "Developer", "abc@domain.com"));
		uList.add(new User("XYZ", "Developer", "xyz@domain.com"));
		uList.add(new User("PM", "ProjectManager", "pm@domain.com"));
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. import User\n2. Register\n3. Login");
			System.out.println("Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// System.out.println("Enter File Name: ");
				// String path = sc.next();
				try {
					uService.importUser(uList);
				} catch (EmailExistsException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					uService.registerUser("pm@domain.com", "ProjectManager", "abcd123");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					User u = uService.userLogin("xyz@domain.com", "abcd123");
					System.out.println("Login Succesfull");
					System.out.println(u);
					choice = 4;
				} catch (UserNotRegisteredException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				break;
			}
		} while (choice != 4);
	}
}
