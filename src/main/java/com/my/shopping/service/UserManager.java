package com.my.shopping.service;

import java.util.List;

import com.my.shopping.model.User;

public interface UserManager {

	public long createUser(User user);
	public User getUserByName(String userName);
	public boolean ifUserExists(String userName);
	public List<User> queryUser();
	public List<User> queryUser(int start, int limit);
	public long getUserCount();
}
