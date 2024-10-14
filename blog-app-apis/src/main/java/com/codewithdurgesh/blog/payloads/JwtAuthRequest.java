package com.codewithdurgesh.blog.payloads;

public class JwtAuthRequest {

	private String username;
	
	private String password;

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

	public JwtAuthRequest() {
		// TODO Auto-generated constructor stub
	}

	public JwtAuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}