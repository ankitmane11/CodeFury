package com.app.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
				//InputStream is = new FileInputStream(request.getInputStream());
				JsonReader reader = new JsonReader(br);
			) {
				reader.beginArray();
				while(reader.hasNext()) {
					userData.add(gson.fromJson(reader, User.class));
//					System.out.println("User Data: "+userData);
				}
				reader.endArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UserService uservice = new UserServiceImpl();
		try {
			uservice.importUser(userData);
//			uservice.importUser(userData);
		} catch (EmailExistsException e) {
			out.println("Email Already Exists!!");
			//name of page yet to be replaced depending on front end
			this.getServletContext().getRequestDispatcher("/import.jsp").include(request, response);
		}
//		out.println("Importing Done!!");
		this.getServletContext().getRequestDispatcher("/import.jsp").include(request, response);
	}
}

