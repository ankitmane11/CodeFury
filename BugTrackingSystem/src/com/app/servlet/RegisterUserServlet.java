package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.beans.User;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String pass = request.getParameter("pass");
		
		UserService uservice = new UserServiceImpl();
		
		try {
			uservice.registerUser(email, role, pass);
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		} catch (Exception e1) {
			out.println("Error Exists!!");
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);
		}
		
		PrintWriter out1 = response.getWriter();
		out.println("Registration Done!!");
		this.getServletContext().getRequestDispatcher("/users.jsp").include(request, response);
	}
}

