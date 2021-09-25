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
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

@WebServlet("/displayTester")

public class DisplayTester extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			UserService userservice=new UserServiceImpl();
			BugDao bugdao = new BugDaoImpl();
			String email = request.getParameter("username");
			String password = request.getParameter("email");

			User testeruser;
			List<Bugs> bugList = new ArrayList<>();

			try
			{
				testeruser = userservice.userLogin(email, password);
				buglist = bugdao.getBugsForTester(testeruser.id);
			
			} catch (UserNotRegisteredException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("user", testeruser);
			request.setAttribute("buglist", buglist);

			RequestDispatcher rd=request.getRequestDispatcher("displayTester.jsp");
			rd.forward(request, response);
		}	
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
		}
}