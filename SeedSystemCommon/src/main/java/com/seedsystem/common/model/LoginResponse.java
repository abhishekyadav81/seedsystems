package com.seedsystem.common.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4366559990624411652L;

	private Boolean authenticated;
	
	private String token;
	
	private String userName;
	
	public LoginResponse(Boolean authenticated) {
		this.authenticated=authenticated;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
