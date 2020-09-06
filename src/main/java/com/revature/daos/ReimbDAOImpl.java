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
	public Reimb findById(int id) {
		Session ses = ConnectUtil.getSession();
		Reimb r = ses.get(Reimb.class, id);
		return r;
	}

	@Override
	public List<Reimb> findByType(int id) {
		Session ses = ConnectUtil.getSession();
		List<Reimb> list = ses.createQuery("FROM Reimb WHERE type = " + id, Reimb.class).list();
		return list;
	}

	@Override
	public List<Reimb> findByStatus(int id) {
		Session ses = ConnectUtil.getSession();
		List<Reimb> list = ses.createQuery("FROM Reimb WHERE status = " + id, Reimb.class).list();
		return list;
	}

	@Override
	public List<Reimb> findAll() {
		Session ses = ConnectUtil.getSession();
		List<Reimb> list = ses.createQuery("FROM Reimb", Reimb.class).list();
		return list;
	}

	@Override
	public ReimbType findTypeId(int id) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ReimbType type = ses.get(ReimbType.class, id);
			return type;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ReimbStatus findStatusId(int id) {
		Session ses = ConnectUtil.getSession();
		
		try {
			ReimbStatus status = ses.get(ReimbStatus.class, id);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
