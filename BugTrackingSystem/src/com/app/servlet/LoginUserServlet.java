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
import com.app.exceptions.UserNotRegisteredException;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		UserService uservice = new UserServiceImpl();
		User user;
		try {
			user = uservice.userLogin(uname, pass);

			// creating session and setting attributes
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("email", email);
			session.setAttribute("pass", pass);
			session.setAttribute("type", user.getType());
			session.setAttribute("id", user.getId());

			if (user.getType().equals("Project Manager")) {
				RequestDispatcher rd = request.getRequestDispatcher("mainmanager.jsp");
				rd.forward(request, response);
			} else if (user.getType().equals("Developer")) {
				RequestDispatcher rd = request.getRequestDispatcher("DisplayDeveloper.jsp");
				rd.forward(request, response);
			} else if (user.getType().equals("Tester")) {
				RequestDispatcher rd = request.getRequestDispatcher("DisplayTester.jsp");
				rd.forward(request, response);
			} else {
				out.println("<h1>Please Re-enter Credentials!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}

		} catch (UserNotRegisteredException e) {
			out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}

		PrintWriter out1 = response.getWriter();
		out.println("Login Done!!");
		this.getServletContext().getRequestDispatcher("/users.jsp").include(request, response);
	}
}
