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
				if (req.getMethod().equals("GET")) {
					if (portions.length == 2) {
						int id = Integer.parseInt(portions[1]);
						rc.getReimb(res, id);
					} else if (portions.length == 3 && portions[1].equals("status")) {
						int id = Integer.parseInt(portions[2]);
						rc.getReimbStatus(res, id);
					} else if (portions.length == 3 && portions[1].equals("type")) {
						int id = Integer.parseInt(portions[2]);
						rc.getReimbType(res, id);
					} else if (portions.length == 1) {
						if (lc.setUser(req, res).getType().getId() == 2) {
							int id = lc.setUser(req, res).getId();
							rc.getReimbUser(res, id);
						} else {
							rc.getAllReimb(res);
						}
					}
				} else if (req.getMethod().equals("POST")) {
					if (lc.setUser(req, res).getType().getId() == 2) {
						rc.addReimb(req, res);
					} else if (lc.setUser(req, res).getType().getId() == 1) {
						rc.updateReimb(req, res);
					}
				}
				break;
			case "login":
				lc.login(req, res);
				break;
			case "logout":
				lc.logout(req, res);
				break;
			case "success":
				lc.setUser(req, res);
				lc.json(req, res);
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
