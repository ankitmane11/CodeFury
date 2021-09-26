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
import com.app.exceptions.BugNotFoundException;
import com.app.service.BugService;
import com.app.service.BugServiceImpl;

@WebServlet("/assignBug")
public class AssignBugServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			BugService bugservice=new BugServiceImpl();
			
			int bugId = (int) session.getAttribute("bugId");
			int developerId = Integer.parseInt(request.getParameter("developerId"));

			try {
				bugservice.assignBug(developerId, bugId);
			} catch (BugNotFoundException e) {
				e.printStackTrace();
			}
			out.println("Bug assigned!");

			RequestDispatcher rd=request.getRequestDispatcher("buginfo.jsp");
			rd.forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}