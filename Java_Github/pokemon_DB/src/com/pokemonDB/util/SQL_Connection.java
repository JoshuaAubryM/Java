package com.pokemonDB.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL_Connection {
	static String Driver = "com.mysql.cj.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/pokemonCards";
	static String USERNAME = "root";
	static String PASSWORD = "@llTh3W0rld";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start_connection();
	}

	public static Connection start_connection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Class.forName(Driver);
			System.out.println("Connection Successful");
		} catch (ClassNotFoundException | SQLException e ) {
			//	class exception and connection exception;
			e.getStackTrace();
		}
		return connect;
	}
}
