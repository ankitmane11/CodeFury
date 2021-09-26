package com.app.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.app.beans.User;
import com.app.exceptions.EmailAlreadyExistsException;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mysql.cj.conf.ConnectionUrl.Type;

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
				InputStream is = new FileInputStream(importUserPath);
				JsonReader reader = new JsonReader( new InputStreamReader(is));
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
			uservice.importUser(importUserPath);
//			uservice.importUser(userData);
		} catch (EmailAlreadyExistsException e) {
			out.println("Email Already Exists!!");
			//name of page yet to be replaced depending on front end
			this.getServletContext().getRequestDispatcher("/users.jsp").include(request, response);
		}
//		out.println("Importing Done!!");
		this.getServletContext().getRequestDispatcher("/users.jsp").include(request, response);
	}
}

