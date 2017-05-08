package com.atmecs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atmecs.pojo.TechTalk;
import com.atmecs.pojo.User;

public class LoginDao {
	
	public static boolean validateAdmin(String email,String password) throws SQLException
	{
		if(email.equalsIgnoreCase("admin@atmecs.com") && password.equalsIgnoreCase("admin"))
			return true;
		return false;
	}

	public static User validateUser(String email,String pass) throws SQLException{

	Connection dbConnection = DbUtils.getConnection();
	Statement statement = null;
	String selectTableSQL = "SELECT * from user where email='"+email+"'and password ='"+pass+"'";
	
	statement = dbConnection.createStatement();

	System.out.println(selectTableSQL);


	ResultSet rs = statement.executeQuery(selectTableSQL);
	
	if(rs.next())
		return new User(rs.getString(1), rs.getString(2),rs.getString(3));
	return null;	

	}
	
	public static void registerUser(User u) throws SQLException{

		Connection dbConnection = DbUtils.getConnection();
		PreparedStatement stmt=dbConnection.prepareStatement("insert into User values(?,?,?)");  
		stmt.setString(1,u.getEmail());//1 specifies the first parameter in the query  
		stmt.setString(2,u.getName());
		stmt.setString(3, u.getPassword());
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
	}
		
	public static List<TechTalk> fetchData() throws Exception{
		Connection dbConnection = DbUtils.getConnection();
		List<TechTalk> tl = new ArrayList<>();
		
		String query="select * from details_techtalk";
		Statement stmt=dbConnection.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		
		
		while(rs.next()){
			tl.add(new TechTalk(rs.getInt("Tid"), rs.getString("Title"), rs.getString("Description"), rs.getString("Speaker"),rs.getDate("Date"), rs.getTime("Time")));
		}
		
		System.out.println("fetch data successfully");
		return tl;
		
		
	}

	
	
}	
	
	
	
	
	
	
	
	
	
	
	

