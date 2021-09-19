package com.app.beans;

public class User {

	private int id;
	private String name;
	private String type;
	private String email;
	private String password;
	
	//Default Constructor
	public User() {
		super();
	}

	//Parameterized Constructor
	public User(String name, String type, String email) {
		super();
		this.name = name;
		this.type = type;
		this.email = email;
		this.id = 0;
		this.password = null;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
