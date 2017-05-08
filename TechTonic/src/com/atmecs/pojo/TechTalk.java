package com.atmecs.pojo;

import java.util.Date;
import java.sql.Time;

public class TechTalk {
	private int Tid;
	private String Title;
	private String Description;
	 private String Speaker;
	 private Date Date;
	 private  Time Time;
	 
	 
	public TechTalk() {
	}
	public TechTalk(int tid, String title, String description, String speaker,Date date2,Time time) {
		super();
		Tid = tid;
		Title = title;
		Description = description;
		Speaker = speaker;
		Date = date2;
		Time = time;
	}

	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
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
		return "TechTalk [Tid=" + Tid + ", Title=" + Title + ", Description=" + Description + ", Speaker=" + Speaker
				+ ", Date=" + Date + ", Time=" + Time + "]";
	}
}
