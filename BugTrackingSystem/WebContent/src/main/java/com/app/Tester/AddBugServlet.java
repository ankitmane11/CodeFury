package com.app.Tester;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.Bugs;
import com.app.beans.User;
import com.app.dao.BugDao;
import com.app.dao.BugDaoImpl;
import com.app.exceptions.BugNotAddedException;
import com.app.exceptions.BugNotFoundException;

@WebServlet("/addBug")

public class AddBugServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			response.setContentType("text/html");
			BugDao bugservice = new BugDaoImpl();
			String projectname = request.getParameter("projectname");
			String bugname = request.getParameter("bugname");
			int createdBy = Integer.parseInt(request.getParameter("testerid"));
			// String to date conversion:-
			LocalDate openDate = LocalDate.parse(request.getParameter("opendate"));
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String severityLevel = request.getParameter("severitylevel");

			try {
				try {
					bugservice.createBug(projectname, new Bugs(bugname, description, createdBy, openDate, severityLevel));
				} catch (BugNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.getWriter().write("Bug Added!");
			}

			catch (BugNotAddedException e) {
				response.getWriter().write(e.getMessage());
			}

			RequestDispatcher rd = request.getRequestDispatcher("AddBug.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}