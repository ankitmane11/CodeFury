package com.app.beans;

import java.util.Date;

public class Project {

	private int id;
	private String name;
	private String description;
	private Date startDate;
	private String status;
	private String teamMembers;

	// Default Constructor
	public Project() {
		super();
	}

	public Project(String name, String description, Date startDate, String status, String teamMembers) {
		super();
		this.id = 0;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
		this.teamMembers = teamMembers;
	}

	// Parameterized Constructor
	public Project(int id, String name, String description, Date startDate, String status, String teamMembers) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
		this.teamMembers = teamMembers;
	}

	// Getters and Setters
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(String teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", status=" + status + ", teamMembers=" + teamMembers + "]";
	}

}
