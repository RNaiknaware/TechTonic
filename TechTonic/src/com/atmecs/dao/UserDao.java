package com.atmecs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import com.atmecs.pojo.RequestTechTalk;
public class UserDao {

	static Connection dbConnection = DbUtils.getConnection();
	//Statement statement = null;
	
	public static void RegisterTechTalk(int tid,String email)
	{
		try {
			PreparedStatement insertSQl=dbConnection.prepareStatement("insert into registered_employees values(?,?)");  
			insertSQl.setString(1,email);
			insertSQl.setInt(2,tid);//1 specifies the first parameter in the query
			int a=insertSQl.executeUpdate();
			System.out.println(a+" rows affected");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	}
	
	public static void requestTechTalk(RequestTechTalk tt2)
	{
		Connection dbConnection = DbUtils.getConnection();
		//Statement statement = null;
		SimpleDateFormat dd =new SimpleDateFormat("yyyy-MM-dd");
		String date = dd.format(tt2.getDate());
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		String time = sdf.format(tt2.getTime());
		
		try {
			//statement = dbConnection.createStatement();
			
			PreparedStatement stmt=dbConnection.prepareStatement("insert into request_techtalk (Title,Description,Speaker,Date,Time) values(?,?,?,?,?)");  
			//1 specifies the first parameter in the query  
			stmt.setString(1,tt2.getTitle());
			stmt.setString(2,tt2.getDescription());
			stmt.setString(3, tt2.getSpeaker());
			stmt.setString(4,date);
			stmt.setString(5, time);
			
			
			  
			int i=stmt.executeUpdate();  
			System.out.println("User Dao"+i+" records inserted");  
			
			
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}
		}
	    
}

