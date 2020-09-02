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
		User u = udao.findById(rd.author);
		ReimbStatus status = dao.findStatusId(rd.status);
		ReimbType type = dao.findTypeId(rd.type);
		
		if (rd.description == "" || rd.receipt == "") {
			Reimb r = new Reimb(rd.amt, rd.submitted, u, status, type);
			return dao.add(r);
		} else {
			Reimb r = new Reimb(rd.amt, rd.submitted, rd.description, rd.receipt, u, status, type);
			return dao.add(r);
		}
	}
	
	public boolean update(Reimb r) {
		return dao.update(r);
	}
	
	public boolean delete(int id) {
		return dao.delete(id);
	}

}
