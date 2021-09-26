package com.app.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.beans.Bugs;
import com.app.exceptions.BugNotAddedException;
import com.app.exceptions.BugNotFoundException;
import com.app.service.BugService;
import com.app.service.BugServiceImpl;

public class TestBug {
	public static void main(String[] args) {
		BugService bService = new BugServiceImpl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Create Bug\n2. Get Bugs for Project\n3. Assign Bug\n4.Close Bug\n5.Get Bugs for User");
			System.out.println("Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					bService.createBug("Bug Tracker", new Bugs("bug1", "Causing problems", 3, LocalDate.of(2021, 9, 24), "High"));
				} catch (BugNotFoundException | BugNotAddedException e1) {
					System.out.println(e1.getMessage());
				}
					
				 
				break;
			case 2:
				List<Bugs> bList = new ArrayList<>();
				try {
					bList = bService.getBugsForProject(1);
					for(Bugs b: bList)
						System.out.println(b);
					//bList.stream().forEach(System.out::println);
				} catch (BugNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;

			default:
				break;
			}
		}while(choice != 5);
	}
}
