package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.models.UserType;

public interface UserDAO {
	
	public boolean add(User u);
	public boolean update(User u);
	public boolean delete(int id);
	public User findById(int id);
	public User findByName(String username);
	public boolean checkCreds(String username, String password);
	public List<User> findByType(UserType type);
	public List<User> findAll();
	public UserType findTypeId(int id);

}
