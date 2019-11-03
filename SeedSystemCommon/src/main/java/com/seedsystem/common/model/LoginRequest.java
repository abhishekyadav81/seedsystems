package com.seedsystem.common.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRequest {

	@NotNull
	private String emailUserId;
	@NotNull
	private String password;
	
	
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
	
	
	
}
