package com.app.servlet;

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

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserServletInfo extends HttpServlet 
{
	public UserServletInfo()
	{
		super();
	}
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			/*
			response.setContentType("text/html");
			UserService userservice=new UserServiceImpl();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user1;
			int managerId;
			try {
				user1 = userservice.userLogin(email, password);
			} catch (UserNotRegisteredException e) 
			{
				e.printStackTrace();
			}
			*/
			request.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher("userinfo.jsp");
			rd.forward(request, response);
		}
		else 
		{
			out.println("<h1>Please Re-enter Credentials!</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}