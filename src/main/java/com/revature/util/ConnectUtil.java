package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
	
public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://demosdb.cnhivgivm0u1.us-east-1.rds.amazonaws.com:5432/project1";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	public static void main(String[] args) {
		try (Connection conn = ConnectUtil.getConnection()) {
			System.out.println("connection successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
