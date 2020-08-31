package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.util.ConnectUtil;

public class UserDAOImpl implements UserDAO {
	
	@Override
	public boolean add(User u) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ses.save(u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(User u) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ses.merge(u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(int id) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ses.createQuery("DELETE FROM User WHERE id = " + id);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User findById(int id) {
		Session ses = ConnectUtil.getSession();
		User u = ses.get(User.class, id);
		return u;
	}

	@Override
	public User findByName(String username) {
		Session ses = ConnectUtil.getSession();
		User u = ses.get(User.class, username);
		return u;
	}

	@Override
	public List<User> findByType(UserType type) {
		Session ses = ConnectUtil.getSession();
		List<User> list = ses.createQuery("FROM User WHERE type = " + type).list();
		return list;
	}

	@Override
	public List<User> findAll() {
		Session ses = ConnectUtil.getSession();
		List<User> list = ses.createQuery("FROM User").list();
		return list;
	}

	@Override
	public boolean checkCreds(String username, String password) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ses.createQuery("FROM User WHERE username = " + username + " AND password = " + password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
