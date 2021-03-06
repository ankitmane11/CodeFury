package com.app.beans;

import java.time.LocalDate;
import java.util.Date;

public class Bugs {

	private int id;
	private String title;
	private String description;
	private int projectId;
	private int createdBy;
	private LocalDate openDate;
	private int assignedTo;
	private Boolean markedForClosing;
	private int closedBy;
	private LocalDate closedOn;
	private String status;
	private String severityLevel;

	// Default Constructor
	public Bugs() {
		super();

	}

	// Parameterized Constructor for adding
	public Bugs(String title, String description, int createdBy, LocalDate openDate,
			String severityLevel) {
		super();
		this.id = 0;
		this.title = title;
		this.description = description;
		this.projectId = 0;
		this.createdBy = createdBy;
		this.openDate = openDate;
		this.severityLevel = severityLevel;
		this.markedForClosing = false;
		this.status = "open";
		this.assignedTo = 0;
		this.closedBy = 0;
		this.closedOn = null;
	}

	//
	public Bugs(int id, String title, String description, int projectId, int createdBy, LocalDate openDate, int assignedTo,
			Boolean markedForClosing, int closedBy, LocalDate closedOn, String status, String severityLevel) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.projectId = projectId;
		this.createdBy = createdBy;
		this.openDate = openDate;
		this.assignedTo = assignedTo;
		this.markedForClosing = markedForClosing;
		this.closedBy = closedBy;
		this.closedOn = closedOn;
		this.status = status;
		this.severityLevel = severityLevel;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Boolean getMarkedForClosing() {
		return markedForClosing;
	}

	public void setMarkedForClosing(Boolean markedForClosing) {
		this.markedForClosing = markedForClosing;
	}

	public int getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(int closedBy) {
		this.closedBy = closedBy;
	}

	public LocalDate getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(LocalDate closedOn) {
		this.closedOn = closedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(String severityLevel) {
		this.severityLevel = severityLevel;
	}

	@Override
	public String toString() {
		return "Bugs [id=" + id + ", title=" + title + ", description=" + description + ", projectId=" + projectId
				+ ", createdBy=" + createdBy + ", openDate=" + openDate + ", assignedTo=" + assignedTo
				+ ", markedForClosing=" + markedForClosing + ", closedBy=" + closedBy + ", closedOn=" + closedOn
				+ ", status=" + status + ", severityLevel=" + severityLevel + "]";
	}
	
}
