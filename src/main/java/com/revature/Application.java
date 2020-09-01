package com.revature;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;

public class Application {
	
	public static UserDAO udao = new UserDAOImpl();
	
	public static void main(String[] args) {
		
		insert();
		List<User> users = udao.findAll();
		
		for (User u : users) {
			System.out.println(u);
		}
		
	}
	
	public static void insert() {
		String p1 = "1234hash";
		StringBuilder sb1 = new StringBuilder();
		sb1.append(p1.hashCode());
		String p1hash = sb1.toString();
		User u1 = new User("username", p1hash, "sir drake", "sinclair", "drake@email.com", udao.findTypeId(2));
		
		String p2 = "password";
		StringBuilder sb2 = new StringBuilder();
		sb2.append(p2.hashCode());
		String p2hash = sb2.toString();
		User u2 = new User("whatsup", p2hash, "maam", "obadiah", "igloo@email.net", udao.findTypeId(2));
		
		String p3 = "dedede";
		StringBuilder sb3 = new StringBuilder();
		sb3.append(p3.hashCode());
		String p3hash = sb3.toString();
		User u3 = new User("ioio", p3hash, "hello", "freya", "odin@norse.org", udao.findTypeId(1));
		
		udao.add(u1);
		udao.add(u2);
		udao.add(u3);
	}

}
