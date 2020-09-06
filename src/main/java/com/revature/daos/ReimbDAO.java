package com.revature.daos;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;

public interface ReimbDAO {
	
	public boolean add(Reimb r);
	public boolean update(Reimb r);
	public boolean delete(int id);
	public Reimb findById(int id);
	public ReimbType findTypeId(int id);
	public ReimbStatus findStatusId(int id);
	public List<Reimb> findByType(int id);
	public List<Reimb> findByStatus(int id);
	public List<Reimb> findAll();

}
