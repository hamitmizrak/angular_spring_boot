package com.hamit.security;

public class LoginAuth {
	
	private String username;
	private String password;
	
	public LoginAuth() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginAuth(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
