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

@WebServlet("/closeBug")

public class CloseBugServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			BugService bugservice=new BugServiceImpl();
			int id = (int) session.getAttribute("bugId");
			
			try {
				bugservice.closeBug(id);
			} catch (BugNotFoundException e) {
				e.printStackTrace();
			}
			out.println("Bug closed!");

			RequestDispatcher rd=request.getRequestDispatcher("buginfo.jsp");
			rd.forward(request, response);
		}	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}

