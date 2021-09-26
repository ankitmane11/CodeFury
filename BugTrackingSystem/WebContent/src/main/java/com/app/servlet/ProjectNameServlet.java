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

import com.app.beans.Project;
import com.app.beans.User;
import com.app.service.ProjectService;
import com.app.service.ProjectServiceImpl;

/**
 * Servlet implementation class ProjectNameServlet
 */
@WebServlet("/ProjectNameServlet")
public class ProjectNameServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) 
		{
			response.setContentType("text/html");
			
			int managerId;
//			user1 = userservice.userLogin(email, password);
			managerId = user.getId();
			
			ProjectService projectservice = new ProjectServiceImpl();
			List<Project> projects = projectservice.getProjectList(managerId);
			request.setAttribute("projects", projects);
			
			RequestDispatcher rd=request.getRequestDispatcher("projectname.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}