package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.util.ConnectUtil;

public class ReimbDAOImpl implements ReimbDAO {

	@Override
	public boolean add(Reimb r) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ses.save(r);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Reimb r) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ses.merge(r);
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
			ses.createQuery("DELETE FROM Reimb WHERE id = " + id);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Reimb selectById(int id) {
		
		return null;
	}

	@Override
	public List<Reimb> findByType(ReimbType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimb> findByStatus(ReimbStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimb> findAll() {
		Session ses = ConnectUtil.getSession();
		List<Reimb> list = ses.createQuery("SELECT * FROM Reimb").list();
		return list;
	}

}
