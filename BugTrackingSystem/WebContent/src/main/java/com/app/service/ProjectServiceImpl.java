package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.beans.Project;
import com.app.dao.ProjectDao;
import com.app.dao.ProjectDaoImpl;

public class ProjectServiceImpl implements ProjectService {
	
	private ProjectDao pDao;
	public ProjectServiceImpl() {
		super();
		pDao = new ProjectDaoImpl();
	}
	@Override
	public void createProject(String name, String description, LocalDate startDate, String status, List<Integer> team) {
		List<String> teamMembers = new ArrayList<>();
		for (int id : team) {
			teamMembers.add(pDao.getUserName(id));
		}
		pDao.createProject(new Project(name, description, startDate, status, teamMembers), team);
		
	}
	@Override
	public List<Project> getProjectList(int managerId) {
		return pDao.getProjectList(managerId);
	}

}
