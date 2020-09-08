package com.revature.daos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;

public class ReimbDAOImplTest {
	
	private static UserDAO udao = new UserDAOImpl();
	private static ReimbDAO rdao = new ReimbDAOImpl();
	public User u1;
	public User u2;
	public ReimbStatus status;
	public ReimbStatus status2;
	public ReimbType type;

	@Test
	public void setUp() {
		User u1 = udao.findById(1);
		User u2 = udao.findById(3);
		ReimbStatus status = rdao.findStatusId(1);
		ReimbStatus status2 = rdao.findStatusId(2);
		ReimbType type = rdao.findTypeId(2);
	}
	
	@Test
	public void testAdd() {
		Reimb r = new Reimb(50.55, LocalDateTime.now(), null, u1, null, status, type);
		assertTrue(rdao.add(r));
	}

	@Test
	public void testUpdate() {
		Reimb r = rdao.findById(4);
		r.setResolved(LocalDateTime.now());
		r.setResolver(u2);
		r.setStatus(status2);
		assertTrue(rdao.update(r));
	}

	@Test
	public void testDelete() {
		assertTrue(rdao.delete(3));
		assertFalse(rdao.delete(7));
	}

	@Test
	public void testFindById() {
		assertTrue(rdao.findById(1) != null);
		assertFalse(rdao.findById(10) != null);
	}

}
