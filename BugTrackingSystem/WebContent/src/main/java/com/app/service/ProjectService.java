package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.beans.Project;

public interface ProjectService {

	void createProject(String name, String description, LocalDate startDate, String status, List<Integer> team);

	List<Project> getProjectList(int managerId);

}
