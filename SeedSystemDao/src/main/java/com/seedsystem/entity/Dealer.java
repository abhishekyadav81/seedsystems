package com.seedsystem.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 
 */
@Entity
@Table(name = "dealers",schema="usernew")

public class Dealer {//extends AbstractEntity {

  @Id
  @Column(name = "dealertitle", unique = true, nullable = false)
  private String dealerTitle;
  
  @Column(name = "contactperson")
  private String contactPerson;

  @Column(name = "contactnumber", unique = true, nullable = false)
  private String contactNumber;
  
  @Column(name = "state")
  private String state;
  
  @Column(name = "county")
  private String county;
  
  @Column(name = "crop")
  private String crop;

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
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCounty() {
		return county;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	public String getCrop() {
		return crop;
	}
	
	public void setCrop(String crop) {
		this.crop = crop;
	}

}
