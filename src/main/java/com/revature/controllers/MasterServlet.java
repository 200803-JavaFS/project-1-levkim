package com.revature.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static ReimbController rc = new ReimbController();
	private static LoginController lc = new LoginController();
	
	public MasterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project1/", "");
		
		String[] portions = URI.split("/");
		
		System.out.println(Arrays.toString(portions));
		
		try {
			switch (portions[0]) {
			case "reimbursement":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) { 
							int id = Integer.parseInt(portions[1]);
							rc.getReimb(res, id);
						} else if (portions.length == 3 && portions[1].equals("status")) {
							int id = Integer.parseInt(portions[2]);
							rc.getReimb(res, id);
						} else if (portions.length == 3 && portions[1].equals("type")) {
							int id = Integer.parseInt(portions[2]);
							rc.getReimb(res, id);
						} else if (portions.length == 1) {
							rc.getAllReimb(res);
						}
					} else if (req.getMethod().equals("POST")) {
						if (req.getAttribute("user").getClass().getField("role").equals(1)) {
							rc.addReimb(req, res);
						} else if (req.getAttribute("user").getClass().getField("role").equals(2)) {
							rc.updateReimb(req, res);
						}
					}
				} else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
			case "login":
				lc.login(req, res);
				break;
			case "logout":
				lc.logout(req, res);
				break;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.setStatus(400);
		} catch (NoSuchFieldException e) {
			System.out.println("This field does not exist within the class you are accessing!");
			e.printStackTrace();
			res.setStatus(400);
		} catch (SecurityException e) {
			System.out.println("Warning! Security breach!!");
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
