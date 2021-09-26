package com.app.Tester;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.Bugs;
import com.app.beans.Project;
import com.app.beans.User;
import com.app.exceptions.BugNotFoundException;
import com.app.exceptions.UserNotRegisteredException;
import com.app.service.BugService;
import com.app.service.BugServiceImpl;
import com.app.service.ProjectService;
import com.app.service.ProjectServiceImpl;
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
			BugService bugservice = new BugServiceImpl();
			ProjectService projectservice = new ProjectServiceImpl();
			String email = request.getParameter("username");
			String password = request.getParameter("email");

			User testeruser;
			List<Bugs> bugList = new ArrayList<>();
			List<Project> pList = new ArrayList<Project>();
			try
			{
				testeruser = userservice.userLogin(email, password);
				try {
					bugList = bugservice.getBugsForTester(testeruser.getId());
				} catch (BugNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pList = projectservice.getProjectList(testeruser.getId());
				request.setAttribute("user", testeruser);
			} catch (UserNotRegisteredException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("buglist", bugList);

			RequestDispatcher rd=request.getRequestDispatcher("DisplayTester.jsp");
			rd.forward(request, response);
		}	
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
		}
}