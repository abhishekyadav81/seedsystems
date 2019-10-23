package com.seedsystem.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 */
@Entity
@Table(name = "farmer",schema="usernew")

public class Farmer {//extends AbstractEntity {

  @Column(name = "password")
  private String password;

  @Id
  @Column(name = "email", unique = true, nullable = false)
  private String email;
  
  @Column(name = "firstname")
  private String firstName;
  
  @Column(name="salt")
  private String salt;
  
  @Column(name = "lastname", unique = true, nullable = false)
  private String lastName;
  
  @Column(name = "address", unique = true, nullable = false)
  private String address;
  
  @Column(name = "city", unique = true, nullable = false)
  private String city;
  
  @Column(name = "state")
  private String state;

  @Column(name = "zip")
  private String zip;
  
  @Column(name = "officenumber")
  private String contactNumber;

  @Column(name = "creditcardnumber", unique = true, nullable = false)
  private String creditCardNumber;
  
  @Column(name = "cvv")
  private String cvv;
  
  @Column(name = "expdate")
  private Date expdate;
  
  

  public Date getExpdate() {
	return expdate;
}


public void setExpdate(Date expdate) {
	this.expdate = expdate;
}


/**
   * Return the password.
   * 
   * @return the password
   */
  public String getPassword() {
    return password;
  }


  /**
   * Set the password.
   * 
   * @param password
   *          the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }


  

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCreditCardNumber() {
		return creditCardNumber;
	}


	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}




 
}
