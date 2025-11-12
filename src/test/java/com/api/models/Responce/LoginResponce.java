package com.api.models.Responce;

import java.util.List;

public class LoginResponce {
	private String token;
	private String type;
	private String email;
	private String username;
	private int id;
	List<String> Roles;
	
	public LoginResponce() {
		
	}
	
	public LoginResponce(String token, String type, String email, String username, int id, List<String> roles) {
		super();
		this.token = token;
		this.type = type;
		this.email = email;
		this.username = username;
		this.id = id;
		Roles = roles;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getRoles() {
		return Roles;
	}
	public void setRoles(List<String> roles) {
		Roles = roles;
	}
	
	@Override
	public String toString() {
		return "LoginResponce [token=" + token + ", type=" + type + ", email=" + email + ", username=" + username
				+ ", id=" + id + ", Roles=" + Roles + "]";
	}
	
	

}
