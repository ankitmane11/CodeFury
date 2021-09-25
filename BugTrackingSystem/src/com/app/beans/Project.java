package com.app.beans;

import java.time.LocalDate;
import java.util.List;

public class Project {

	private int id;
	private String name;
	private String description;
	private LocalDate startDate;
	private String status;
	private List<String> teamMembers;

	// Default Constructor
	public Project() {
		super();
	}

	public Project(String name, String description, LocalDate startDate, String status, List<String> teamMembers) {
		super();
		this.id = 0;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
		this.teamMembers = teamMembers;
	}

	// Parameterized Constructor
	public Project(int id, String name, String description, LocalDate startDate, String status, List<String> teamMembers) {
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", status=" + status + ", teamMembers=" + teamMembers + "]";
	}

}
