package com.app.dao;

import java.util.Date;
import java.util.List;

import com.app.beans.Project;

public interface ProjectDao {

	void createProject(Project p, List<Integer> team);

	String getUserName(int id);

	List<Project> getProjectList(int managerId);

}
