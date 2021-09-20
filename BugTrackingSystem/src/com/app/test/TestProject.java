package com.app.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.app.beans.Project;
import com.app.service.ProjectService;
import com.app.service.ProjectServiceImpl;

public class TestProject {
	public static void main(String[] args) {
		ProjectService pService = new ProjectServiceImpl();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		int choice = 0;
		do {
			System.out.println("1. Create Project\n2. Get Project List\n3. Get Project Details");
			System.out.println("Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Integer> team = new ArrayList<>();
				team.add(1);
				team.add(2);
				team.add(3);
				Date date;
				try {
					date = sdf.parse("20/09/2021");
					String str = "This is the description of the project";
					pService.createProject("Bug Tracker", str, date, "In Progress", team);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				List<Project> pList = pService.getProjectList(2);
				System.out.println(pList.size());
				for (Project p : pList) {					
					System.out.println(p);
				}
				break;
			case 3:
				pService.getProjectDetails(1);
				break;
			case 4:
				break;
			}
		} while (choice != 4);
	}
}
