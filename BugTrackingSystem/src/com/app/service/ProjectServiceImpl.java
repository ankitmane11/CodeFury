package com.app.service;

import java.util.Date;
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
	public void createProject(String name, String description, Date startDate, String status, List<Integer> team) {
		String teamMembers = "";
		for (int id : team) {
			teamMembers += pDao.getUserName(id) + ",";
		}
		teamMembers = teamMembers.substring(0, teamMembers.length()-1);
		pDao.createProject(new Project(name, description, startDate, status, teamMembers), team);
		
	}
	@Override
	public List<Project> getProjectList(int managerId) {
		return pDao.getProjectList(managerId);
	}
	@Override
	public void getProjectDetails(int projectId) {
		
	}

}
