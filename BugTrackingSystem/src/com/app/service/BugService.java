package com.app.service;

import java.util.List;

import com.app.beans.Bugs;
import com.app.exceptions.BugNotAddedException;
import com.app.exceptions.BugNotFoundException;

public interface BugService {

	void createBug(String string, Bugs bugs) throws BugNotFoundException, BugNotAddedException;

	List<Bugs> getBugsForProject(int i) throws BugNotFoundException;

	void assignBug(int userId, int bugId) throws BugNotFoundException;
	
	void closeBug(int bugId) throws BugNotFoundException;
	
	List<Bugs> getBugsForDeveloper(int userId) throws BugNotFoundException;
	
	List<Bugs> getBugsForTester(int userId) throws BugNotFoundException;
}
