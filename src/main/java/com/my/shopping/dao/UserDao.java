package com.my.shopping.dao;

import java.util.List;

import com.my.shopping.model.User;

public interface UserDao {

	public long createUser(User user);

	public void deleteUser(User user);

	public void deleteUser(long id);

	public void updateUser(User user);

	public List<User> queryUser();

	public List<User> queryUser(int start, int limit);

	public List<User> getUserByName(String userName);

	public long getUserCount();
}
