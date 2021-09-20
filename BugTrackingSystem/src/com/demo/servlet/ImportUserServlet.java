package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/importUser")
public class ImportUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserService uservice = new UserServiceImpl();
//		List<User> ulist = uservice.importUser();
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("Importing Done!!");
		this.getServletContext().getRequestDispatcher("/users.jsp").include(request, response);
	}
}
