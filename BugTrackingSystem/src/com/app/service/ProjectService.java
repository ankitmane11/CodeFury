package com.app.service;

import java.util.Date;
import java.util.List;

import com.app.beans.Project;

public interface ProjectService {

	void createProject(String name, String description, Date startDate, String status, List<Integer> team);

	List<Project> getProjectList(int managerId);

	void getProjectDetails(int projectId);

}
