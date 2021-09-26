package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.User;
import com.app.service.ProjectService;
import com.app.service.ProjectServiceImpl;

@WebServlet("/newProject")

public class NewProjectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			ProjectService projectservice=new ProjectServiceImpl();
			String projectName = request.getParameter("projectName");
			String description = request.getParameter("description");
			
			LocalDate startDate =  LocalDate.parse(request.getParameter("startDate"));
			List<Integer> teammembers = new ArrayList<>();
			teammembers.add(101);
			teammembers.add(105);
//			String teammembers = request.getParameter("teammembers");
			
			projectservice.createProject(projectName, description, startDate, "new", teammembers);
			out.println("New Project Created!");

			RequestDispatcher rd=request.getRequestDispatcher("displayManager.jsp");
			rd.forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}




	
}