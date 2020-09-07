package com.revature.services;

import java.time.LocalDateTime;
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
	
	public List<Reimb> findByStatus(int status) {
		return dao.findByStatus(status);
	}
	
	public List<Reimb> findByType(int type) {
		return dao.findByType(type);
	}
	
	public List<Reimb> findByUser(int id) {
		return dao.findByUser(id);
	}
	
	public Reimb findById(int id) {
		return dao.findById(id);
	}
	
	public boolean add(ReimbDTO rd) {
		User u = udao.findById(rd.author);
		ReimbStatus status = dao.findStatusId(rd.status);
		ReimbType type = dao.findTypeId(rd.type);
		
		if (rd.receipt == null) {
			Reimb r = new Reimb(rd.amt, rd.submitted, null, rd.description, null, u, null, status, type);
			return dao.add(r);
		} else {
			Reimb r = new Reimb(rd.amt, rd.submitted, null, rd.description, rd.receipt, u, null, status, type);
			return dao.add(r);
		}
	}
	
	public boolean update(ReimbDTO rd) {
		Reimb r = dao.findById(rd.id);
		ReimbStatus status = dao.findStatusId(rd.status);
		User u = udao.findById(rd.resolver);
		
		try {
			if (r.getResolver().equals(null)) {
				r.setStatus(status);
				r.setResolver(u);
				r.setResolved(LocalDateTime.now());
				return dao.update(r);
			} else {
				System.out.println("This reimbursement is already resolved!");
			}
		} catch (Exception e) {
			System.out.println("Error occurred with updating reimbursements!");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(int id) {
		return dao.delete(id);
	}

}
