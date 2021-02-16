package com.cognizant.model;

public class AuthResponse {
	private String uid;
	private String name;
	private boolean isValid;
	private String role;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public AuthResponse(String uid, String name, boolean isValid, String role) {
		super();
		this.uid = uid;
		this.name = name;
		this.isValid = isValid;
		this.role = role;
	}
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
