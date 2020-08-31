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
		if (portions.length == 0) {
			req.getRequestDispatcher("index.html").forward(req, res);
		}
		
		try {
			switch (portions[0]) {
			case "reimbursement":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							rc.getReimb(res, id);
						} else if (portions.length == 1) {
							rc.getAllReimb(res);
						}
					} else if (req.getMethod().equals("POST")) {
						rc.addReimb(req, res);
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
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
