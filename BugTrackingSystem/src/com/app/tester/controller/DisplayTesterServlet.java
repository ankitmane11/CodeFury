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

import com.app.Exceptions.UserNotRegisteredException;
import com.app.beans.User;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

/**
 * Servlet implementation class DisplayTesterServlet
 */

@WebServlet("/displayTester")

public class DisplayTesterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		if(user!=null) 
		{
			response.setContentType("text/html");
			UserService userservice=new UserServiceImpl();
			
			//String email = request.getParameter("username");
			//String password = request.getParameter("email");

			User user1;
			try 
			{
				//user1 = userservice.userLogin(email, password);
			} 
			catch (UserNotRegisteredException e) 
			{
				e.printStackTrace();
			}
			
			//request.setAttribute("user", user1);
			//RequestDispatcher rd=request.getRequestDispatcher("displayTester.jsp");
			//rd.forward(request, response);
		}	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}
}