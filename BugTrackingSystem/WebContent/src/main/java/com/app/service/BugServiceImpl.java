package com.app.service;

import java.util.List;

import com.app.beans.Bugs;
import com.app.dao.BugDao;
import com.app.dao.BugDaoImpl;
import com.app.exceptions.BugNotAddedException;
import com.app.exceptions.BugNotFoundException;

public class BugServiceImpl implements BugService {

	private BugDao bDao;
	public BugServiceImpl() {
		super();
		bDao = new BugDaoImpl();
	}
	
	@Override
	public void createBug(String string, Bugs bugs) throws BugNotFoundException, BugNotAddedException {
		bDao.createBug(string, bugs);
	}

	@Override
	public List<Bugs> getBugsForProject(int i) throws BugNotFoundException {
		return bDao.getBugsForProject(i);
	}

	@Override
	public void assignBug(int userId, int bugId) throws BugNotFoundException {
		bDao.assignBug(userId, bugId);
	}

	@Override
	public void closeBug(int bugId) throws BugNotFoundException {
		bDao.closeBug(bugId);
		
	}

	@Override
	public List<Bugs> getBugsForDeveloper(int userId) throws BugNotFoundException {
		return bDao.getBugsForDeveloper(userId);
	}

	@Override
	public List<Bugs> getBugsForTester(int userId) throws BugNotFoundException {
		return bDao.getBugsForTester(userId);
	}

}
