package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;

public class LoginController {
	
	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		if (req.getMethod().equals("GET")) {
			res.setStatus(403);
			res.getWriter().println("You're not allowed to use query parameters to log in!");
		} else if (req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			LoginDTO l = om.readValue(body, LoginDTO.class);
			User u = ls.login(l);
			
			if (u != null) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", u);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login successful!");
			} else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login failed.");
			}
		} else {
			res.getWriter().println("A fatal error occurred during login!");
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);
		
		if (ses != null) {
			User u = (User) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().print(u.getUsername() + " successfully logged out!");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to log out. How did you even get here???");
		}
	}
	
	public User setUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if (req.getMethod().equals("GET")) {
			HttpSession ses = req.getSession();
			res.setStatus(200);
			User u = (User) ses.getAttribute("user");
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
			return u;
		} else {
			res.getWriter().println("Something went wrong with checking user details.");
			return null;
		}
	}

}
