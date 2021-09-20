package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
//		String email=request.getParameter("email");
//		String pass=request.getParameter("pass");
//		
//		UserService uservice = new UserServiceImpl();
//		User user=uservice.userLogin(uname,pass);
//		
//		if(user!=null){
//			RequestDispatcher rd=request.getRequestDispatcher("BTSMainPage.html");
//			rd.forward(request, response);
//		}
//		else {
//			out.println("<h1>Please Re-enter Credentials!</h1>");
//			RequestDispatcher rd=request.getRequestDispatcher("login.html");
//			rd.include(request, response);
//		}
		
		PrintWriter out1 = response.getWriter();
		out.println("Login Done!!");
		this.getServletContext().getRequestDispatcher("/users.jsp").include(request, response);
	}
}
