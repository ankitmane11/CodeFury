package com.app.Developer;

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

@WebServlet("/markBugForClosing")


public class MarkBugForClosingServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			BugDao bugservice=new BugDaoImpl();
			int bugId = Integer.parseInt(request.getParameter("bugId"));
			
			bugservice.closeBug(id);
			response.getWriter().write("Bug marked for closing");

			RequestDispatcher rd=request.getRequestDispatcher("MarkBugForDeveloper.jsp");
			rd.forward(request, response);
		}	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}

}