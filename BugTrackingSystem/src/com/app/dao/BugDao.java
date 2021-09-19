package com.app.dao;

import java.util.List;

import com.app.Exceptions.BugNotAddedException;
import com.app.Exceptions.BugNotFoundException;
import com.app.Exceptions.NoBugsFoundException;
import com.app.beans.Bugs;
import com.app.beans.Project;

public interface BugDao {
public List<Bugs> getBugsForProject(int projectId) throws BugNotFoundException;
public void assignBug(int userId, int bugId) throws BugNotFoundException;
public void closeBug(int bugId) throws BugNotFoundException;
public void createBug(String projectName,Bugs bug) throws BugNotFoundException, BugNotAddedException ;
public List<Bugs> getBugsForUser(int userId ) throws BugNotFoundException;
}
