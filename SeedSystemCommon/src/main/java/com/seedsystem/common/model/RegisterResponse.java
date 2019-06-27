package com.seedsystem.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {

	private Boolean userAlreadyExists = false;
	private Boolean userRegisteredSuccessfully=false;

	public Boolean getUserAlreadyExists() {
		return userAlreadyExists;
	}
	public void setUserAlreadyExists(Boolean userAlreadyExists) {
		this.userAlreadyExists = userAlreadyExists;
	}
	public Boolean getUserRegisteredSuccessfully() {
		return userRegisteredSuccessfully;
	}
	public void setUserRegisteredSuccessfully(Boolean userRegisteredSuccessfully) {
		this.userRegisteredSuccessfully = userRegisteredSuccessfully;
	}
	
	
	
}
