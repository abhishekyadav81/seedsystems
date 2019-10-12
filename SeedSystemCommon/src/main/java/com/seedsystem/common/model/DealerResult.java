package com.seedsystem.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DealerResult {

	private String dealerName;
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getDealerContact() {
		return dealerContact;
	}
	public void setDealerContact(String dealerContact) {
		this.dealerContact = dealerContact;
	}
	public String getDealerPhone() {
		return dealerPhone;
	}
	public void setDealerPhone(String dealerPhone) {
		this.dealerPhone = dealerPhone;
	}
	private String dealerContact;
	private String dealerPhone;

	
	
	
}
