package com.atmecs.pojo;

public class Register {
	String email;
	int tid;
	
	public Register() {
		
	}
	public Register(String email, int tid) {
		super();
		this.email = email;
		this.tid = tid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", tid=" + tid + "]";
	}
	
	

}
