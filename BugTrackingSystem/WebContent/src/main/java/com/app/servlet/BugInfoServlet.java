package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.Bugs;
import com.app.beans.User;
import com.app.exceptions.BugNotFoundException;
import com.app.exceptions.UserNotRegisteredException;
import com.app.service.BugService;
import com.app.service.BugServiceImpl;


@WebServlet("/BugInfo")
public class BugInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			BugService bugservice=new BugServiceImpl();
			
			
			int projectId = Integer.parseInt(request.getParameter("projectId"));

			List<Bugs> bugs=null;
			try {
				bugs = bugservice.getBugsForProject(projectId);
			} catch (BugNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bugs", bugs);

			RequestDispatcher rd=request.getRequestDispatcher("buginfo.jsp");
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