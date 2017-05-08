package com.atmecs.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class DbUtils {
	public static Connection getConnection() {
		java.sql.Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	return con;	
	}
}
