package com.atmecs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.atmecs.pojo.Register;
import com.atmecs.pojo.RequestTechTalk;
import com.atmecs.pojo.TechTalk;

public class AdminDao {

	public AdminDao() {
	}
	
	public static void deleteRecord(int tid){
		
		Connection dbConnection = DbUtils.getConnection();
		Statement statement = null;
		int del=0;
		try {
			statement = dbConnection.createStatement();
			String deletesql = "DELETE from details_techtalk where Tid="+tid+"";
			
			del = statement.executeUpdate(deletesql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(del+" rows deleted");		
	}

	public static TechTalk fetchRecord(int tid)
	{
		Connection dbConnection = DbUtils.getConnection();
		Statement statement = null;
		int update=0;
		TechTalk tt = new TechTalk();
		ResultSet rs=null;
		try {
			statement = dbConnection.createStatement();
			String searchRecord="SELECT * from details_techtalk where Tid="+tid+"";
			rs = statement.executeQuery(searchRecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.next();
			
			tt.setTid(rs.getInt("Tid"));
			tt.setTitle(rs.getString("Title"));
			tt.setDescription(rs.getString("Description"));
			tt.setSpeaker(rs.getString("Speaker"));
			tt.setDate(rs.getDate("Date"));
			tt.setTime(rs.getTime("Time"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tt;
		
	}
	

	public static void saveRecord(TechTalk tt) {
		Connection dbConnection = DbUtils.getConnection();
		Statement statement = null;
		SimpleDateFormat dd =new SimpleDateFormat("yyyy-MM-dd");
		String date = dd.format(tt.getDate());
		
		try {
			statement = dbConnection.createStatement();
			String updateQuery = "UPDATE details_techtalk SET Title ='"+tt.getTitle() + "',Description ='"+tt.getDescription()+"',Speaker = '"+tt.getSpeaker()+"',Date = '"+java.sql.Date.valueOf(date)+"',Time='"+tt.getTime()+"' WHERE Tid = "+ tt.getTid();
			statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	
	

	public static void addTechTalk(TechTalk tt){
		Connection dbConnection = DbUtils.getConnection();
		//Statement statement = null;
		SimpleDateFormat dd =new SimpleDateFormat("yyyy-MM-dd");
		String date = dd.format(tt.getDate());
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		String time = sdf.format(tt.getTime());
		
		try {
			PreparedStatement stmt=dbConnection.prepareStatement("insert into details_techtalk values(?,?,?,?,?,?)");  
			stmt.setInt(1,tt.getTid());//1 specifies the first parameter in the query  
			stmt.setString(2,tt.getTitle());
			stmt.setString(3,tt.getDescription());
			stmt.setString(4, tt.getSpeaker());
			stmt.setString(5,date);
			stmt.setString(6, time);
			  
			int i=stmt.executeUpdate();  
			System.out.println("Admin Dao"+i+" records inserted");  
			
			//String insertQuery = "INSERT INTO details_techtalk VALUES (Tid='"+tt.getTid()+"',Title ='"+tt.getTitle() + "',Description ='"+tt.getDescription()+"',Speaker = '"+tt.getSpeaker()+"',Date = '"+java.sql.Date.valueOf(date)+"',Time='"+sdf.format(tt.getTime())+"')" ;
		    //statement.executeUpdate(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static List requestedTechTalk()
	{
		Connection dbConnection = DbUtils.getConnection();
		List<RequestTechTalk> tl = new ArrayList<>();
		
		String query="select * from request_techtalk";
		try {
			Statement stmt=dbConnection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			
			while(rs.next()){
				tl.add(new RequestTechTalk( rs.getString("Title"), rs.getString("Description"), rs.getString("Speaker"),rs.getDate("Date"), rs.getTime("Time")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return tl;
		
		
	}
	
	public static List registeredEmployees(int tid)
	{
		Connection dbConnection = DbUtils.getConnection();
		List<Register> tl = new ArrayList<>();
		
		String query="select * from registered_employees where Tid='"+tid+"'";
		try {
			Statement stmt=dbConnection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			
			while(rs.next()){
				tl.add(new Register(rs.getString("Email"),rs.getInt("Tid") ));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return tl;
		
	}

}
