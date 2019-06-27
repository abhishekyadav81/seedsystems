package com.seedsystem.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterRequest {
	
	private String emailUserId;
	private String password;
	private String confirmedPassword;
	
	
	public String getEmailUserId() {
		return emailUserId;
	}
	public void setEmailUserId(String emailUserId) {
		this.emailUserId = emailUserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
	

}
