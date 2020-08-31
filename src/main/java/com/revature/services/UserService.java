package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;
import com.revature.models.UserType;

public class UserService {
	
	private static UserDAO dao = new UserDAOImpl();
	
	public List<User> findAll() {
		return dao.findAll();
	}
	
	public List<User> findByType(UserType type) {
		return dao.findByType(type);
	}
	
	public User findById(int id) {
		return dao.findById(id);
	}
	
	public User findByName(String username) {
		return dao.findByName(username);
	}
	
	public boolean checkCreds(String username, String password) {
		return dao.checkCreds(username, password);
	}
	
	public boolean add(User u) {
		return dao.add(u);
	}
	
	public boolean update(User u) {
		return dao.update(u);
	}
	
	public boolean delete(int id) {
		return dao.delete(id);
	}

}
