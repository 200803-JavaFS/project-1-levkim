package com.revature.daos;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;

public interface ReimbDAO {
	
	public boolean add(Reimb r);
	public boolean update(Reimb r);
	public boolean delete(int id);
	public Reimb selectById(int id);
	public List<Reimb> findByType(ReimbType type);
	public List<Reimb> findByStatus(ReimbStatus status);
	public List<Reimb> findAll();

}
