package com.app.dao;

import java.util.List;

import com.app.exceptions.BugNotAddedException;
import com.app.exceptions.BugNotFoundException;
import com.app.beans.Bugs;
import com.app.beans.Project;

public interface BugDao {
	public List<Bugs> getBugsForProject(int projectId) throws BugNotFoundException;

	public void assignBug(int userId, int bugId) throws BugNotFoundException;

	public void closeBug(int bugId) throws BugNotFoundException;

	public void createBug(String projectName,Bugs bug) throws BugNotFoundException, BugNotAddedException;

	public List<Bugs> getBugsForDeveloper(int userId) throws BugNotFoundException;
	
	public List<Bugs> getBugsForTester(int userId) throws BugNotFoundException;
}
