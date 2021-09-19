package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	
	//singleton pattern
	private static Connection conn;
	
	public static Connection getMyConnection() {
		try {
		if(conn==null) {
			String url="jdbc:mysql://localhost:3306/codefury_db?useSSL=false";
			String username="root";
			String password="AstonX99";
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn=DriverManager.getConnection(url,username,password);
			conn.setAutoCommit(false);
		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeMyConnection() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
