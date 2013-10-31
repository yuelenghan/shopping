package com.my.shopping.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Component;

import com.my.shopping.dao.UserDao;
import com.my.shopping.model.User;

@Component("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User> implements
		UserDao {

	public long createUser(User user) {
		return this.create(user);
	}

	public void deleteUser(User user) {
		this.delete(user);
	}

	public void deleteUser(long id) {
		User user = new User();
		user.setId(id);
		this.deleteUser(user);
	}

	public void updateUser(User user) {
		this.update(user);
	}

	public List<User> queryUser() {
		return this.query("User");
	}
	
	public List<User> queryUser(int start, int limit) {
		return this.query("User", start, limit);
	}

	public List<User> getUserByName(String userName) {
		return this.queryHql("from User where userName='" + userName + "'");
	}

	public long getUserCount() {
		return this.count("User");
	}

}
