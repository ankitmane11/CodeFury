package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
//		
//		String email = request.getParameter("email");
//		String role = request.getParameter("role");
//		String pass = request.getParameter("pass");
//		
//		User u = new User(email, role, pass);
//		UserService uservice = new UserServiceImpl();
//		
//		try {
//			uservice.registerUser(u);
//			RequestDispatcher rd=request.getRequestDispatcher("login.html");
//			rd.include(request, response);
//		} catch (Exception e1) {
//			out.println("Error Exists!!");
//			RequestDispatcher rd=request.getRequestDispatcher("registerUser.html");
//			rd.include(request, response);
//		}
		
		PrintWriter out1 = response.getWriter();
		out.println("Registration Done!!");
		this.getServletContext().getRequestDispatcher("/users.jsp").include(request, response);
	}
}

