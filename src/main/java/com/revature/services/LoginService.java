package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {
	
	private static UserDAO dao = new UserDAOImpl();
	
	public boolean login(LoginDTO l) {
		try {
			String username = l.username;
			String password = l.password;
			User u = dao.findByName(username);
			
			if (u != null) {
				l.role = u.getType().getId();
				
				StringBuilder sb = new StringBuilder();
				sb.append(password.hashCode());
				String hashed = new String(sb);
				
				if (u.getPassword().equals(hashed) && dao.checkCreds(username, hashed)) {
					return true;
				} else {
					System.out.println("Incorrect credentials entered.");
				}
			} else {
				System.out.println("User does not exist!");
			}
		} catch (NullPointerException e) {
			System.out.println("Login failed.");
			e.printStackTrace();
		}
		return false;
	}

}
