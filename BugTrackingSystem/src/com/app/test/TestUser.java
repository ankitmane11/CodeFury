package com.app.test;

import java.util.Scanner;

import com.app.beans.User;
import com.app.exceptions.EmailAlreadyExistsException;
import com.app.exceptions.UserNotRegisteredException;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

public class TestUser {

	public static void main(String[] args) {
		UserService uService = new UserServiceImpl();
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
					uService.importUser("E:\\HTI Training\\CodeFury\\BugTrackingSystem\\WebContent\\json\\users.json");
				} catch (EmailAlreadyExistsException e) {
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
					User u = uService.userLogin("abc@domain.com", "xyz4321");
					System.out.println("Login Succesfull");
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
