package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {
	
	private static UserDAO dao = new UserDAOImpl();
	
	public boolean login(LoginDTO l) {
		String username = l.username;
		String password = l.password;
		password.hashCode();
		
		User u = dao.findByName(username);
		if (u != null) {
			if (dao.checkCreds(username, password)) {
				return true;
			} else {
				System.out.println("incorrect password!");
				return false;
			}
		}
		return false;
	}

}
