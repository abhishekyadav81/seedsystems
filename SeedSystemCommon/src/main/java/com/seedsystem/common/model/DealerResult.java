package com.seedsystem.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DealerResult implements Cloneable {

	private String dealerTitle;
	private String contactPerson;
	private String contactNumber;
	
	
	public String getDealerTitle() {
		return dealerTitle;
	}
	public void setDealerTitle(String dealerTitle) {
		this.dealerTitle = dealerTitle;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	

	
	
	
}
