package com.revature;

import java.time.LocalDateTime;
import java.util.List;

import com.revature.daos.ReimbDAO;
import com.revature.daos.ReimbDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Reimb;
import com.revature.models.User;

public class Application {
	
	public static UserDAO udao = new UserDAOImpl();
	public static ReimbDAO rdao = new ReimbDAOImpl();
	
	public static void main(String[] args) {
		
		List<User> users = udao.findAll();
		List<Reimb> reimbs = rdao.findAll();
		
		for (User u : users) {
			System.out.println(u);
		}
		
		for (Reimb r : reimbs) {
			System.out.println(r);
		}
		
	}
	
//	public static void insert() {
//		String p1 = "1234hash";
//		StringBuilder sb1 = new StringBuilder();
//		sb1.append(p1.hashCode());
//		String p1hash = new String(sb1);
//		User u1 = new User("username", p1hash, "sir drake", "sinclair", "drake@email.com", udao.findTypeId(2));
//		
//		String p2 = "password";
//		StringBuilder sb2 = new StringBuilder();
//		sb2.append(p2.hashCode());
//		String p2hash = new String(sb2);
//		User u2 = new User("whatsup", p2hash, "maam", "obadiah", "igloo@email.net", udao.findTypeId(2));
//		
//		String p3 = "dedede";
//		StringBuilder sb3 = new StringBuilder();
//		sb3.append(p3.hashCode());
//		String p3hash = new String(sb3);
//		User u3 = new User("ioio", p3hash, "hello", "freya", "odin@norse.org", udao.findTypeId(1));
//		
//		udao.add(u1);
//		udao.add(u2);
//		udao.add(u3);
//		
//		LocalDateTime t1 = LocalDateTime.now();
//		Reimb r1 = new Reimb(20.00, t1, u1, rdao.findStatusId(1), rdao.findTypeId(2));
//		
//		LocalDateTime t2 = LocalDateTime.now();
//		Reimb r2 = new Reimb(50.00, t2, u2, rdao.findStatusId(3), rdao.findTypeId(4));
//		
//		LocalDateTime t3 = LocalDateTime.now();
//		Reimb r3 = new Reimb(50.00, t3, u3, rdao.findStatusId(2), rdao.findTypeId(1));
//		
//		LocalDateTime t4 = LocalDateTime.now();
//		Reimb r4 = new Reimb(50.00, t4, u3, rdao.findStatusId(1), rdao.findTypeId(3));
//		
//		rdao.add(r1);
//		rdao.add(r2);
//		rdao.add(r3);
//		rdao.add(r4);
//	}
}
