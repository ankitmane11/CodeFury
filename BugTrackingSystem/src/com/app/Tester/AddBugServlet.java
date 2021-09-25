package com.app.tester.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.User;
import com.app.exceptions.UserNotRegisteredException;

@WebServlet("/addBug")


public class AddBugServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			BugDao bugservice=new BugDaoImpl();
			String projectname = request.getParameter("projectname");
			String bugname = request.getParameter("bugname");
			String testerid = request.getParameter("testerid");
			//String to date conversion:-
			//String opendate = request.getParameter("opendate");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String severitylevel = request.getParameter("severitylevel");
			
			try {
			bugservice.createBug(projectname, new Bugs(bugname, description, createdBy, openDate, severityLevel));
			response.getWriter().write("Bug Added!");
			}
			
			catch(BugNotAddedException e)
			{
				response.getWriter().write(e.getMessage());
			}
			
			
			RequestDispatcher rd=request.getRequestDispatcher("addBug.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}