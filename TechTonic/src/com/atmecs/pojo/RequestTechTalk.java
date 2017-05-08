package com.atmecs.pojo;

import java.sql.Time;
import java.util.Date;

public class RequestTechTalk {
	private String Title;
	private String Description;
	 private String Speaker;
	 private Date Date;
	 private  Time Time;
	 
	 public RequestTechTalk() {
		// TODO Auto-generated constructor stub
	}
	 
	public RequestTechTalk(String title, String description, String speaker, java.util.Date date, java.sql.Time time) {
		super();
		Title = title;
		Description = description;
		Speaker = speaker;
		Date = date;
		Time = time;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getSpeaker() {
		return Speaker;
	}

	public void setSpeaker(String speaker) {
		Speaker = speaker;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Time getTime() {
		return Time;
	}

	public void setTime(Time time) {
		Time = time;
	}

	@Override
	public String toString() {
		return "RequestTechTalk [Title=" + Title + ", Description=" + Description + ", Speaker=" + Speaker + ", Date="
				+ Date + ", Time=" + Time + "]";
	}
	 
	 

}
