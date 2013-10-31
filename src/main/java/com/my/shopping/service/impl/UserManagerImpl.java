package com.my.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.my.shopping.dao.UserDao;
import com.my.shopping.model.User;
import com.my.shopping.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager {

	private UserDao userDao;

	public long createUser(User user) {
		return userDao.createUser(user);
	}

	public User getUserByName(String userName) {
		List<User> resultList = userDao.getUserByName(userName);
		if (resultList != null && resultList.size() > 0) {
			return resultList.get(0);
		}
		return null;
	}

	public boolean ifUserExists(String userName) {
		User user = this.getUserByName(userName);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public List<User> queryUser(int start, int limit) {
		return userDao.queryUser(start, limit);
	}

	public List<User> queryUser() {
		return userDao.queryUser();
	}
	
	public long getUserCount() {
		return userDao.getUserCount();
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
