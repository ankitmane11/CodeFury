package com.app.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.beans.User;
import com.app.exceptions.EmailExistsException;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


@WebServlet("/importUser")
public class ImportUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		ServletContext context = request.getServletContext();
		String importUserPath = context.getRealPath("/BugTrackingSystem/WebContent/json/users.json");
		
		Gson gson = new Gson();
		List<User> userData = new ArrayList<>();
//		userData = gson.fromJson(jlist, User.class);
		try (
				InputStream is = new FileInputStream(importUserPath);
				JsonReader reader = new JsonReader( new InputStreamReader(is));
			) {
				reader.beginArray();
				while(reader.hasNext()) {
					userData.add((User) gson.fromJson(reader, User.class));
				}
				reader.endArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UserService uservice = new UserServiceImpl();
		try {
			uservice.importUser(userData);
		} catch (EmailExistsException e) {
			out.println("Email Already Exists!!");
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		}
		RequestDispatcher rd=request.getRequestDispatcher("Import.jsp");
		rd.forward(request, response);
	}
}

