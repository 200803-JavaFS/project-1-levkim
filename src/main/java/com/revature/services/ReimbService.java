package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbDAO;
import com.revature.daos.ReimbDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;

public class ReimbService {
	
	private static ReimbDAO dao = new ReimbDAOImpl();
	private static UserDAO udao = new UserDAOImpl();
	
	public List<Reimb> findAll() {
		return dao.findAll();
	}
	
	public List<Reimb> findByStatus(ReimbStatus status) {
		return dao.findByStatus(status);
	}
	
	public List<Reimb> findByType(ReimbType type) {
		return dao.findByType(type);
	}
	
	public Reimb findById(int id) {
		return dao.findById(id);
	}
	
	public boolean add(ReimbDTO rd) {
		User u = udao.findByName(rd.author);
		Reimb r = new Reimb(rd.amt, rd.submitted, u, rd.status, rd.type);
		return dao.add(r);
	}
	
	public boolean update(Reimb r) {
		return dao.update(r);
	}
	
	public boolean delete(int id) {
		return dao.delete(id);
	}

}
