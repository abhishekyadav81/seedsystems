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
@Table(name = "farmer",schema="usernew")

public class Farmer {//extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", unique = true, nullable = false)
  private int userId;

  @Column(name = "password")
  private String password;

  @Column(name = "email", unique = true, nullable = false)
  private String email;
  
  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname", unique = true, nullable = false)
  private String lastName;
  
  @Column(name = "officenumber")
  private String officeNumber;

  @Column(name = "address", unique = true, nullable = false)
  private String address;
  
  @Column(name = "city", unique = true, nullable = false)
  private String city;
  
  @Column(name = "state")
  private String state;

  @Column(name = "county", unique = true, nullable = false)
  private String county;
  
  @Column(name = "zip")
  private String zip;

  @Column(name = "creditcardnumber", unique = true, nullable = false)
  private String creditCardNumber;
  
  @Column(name = "cvv")
  private String cvv;

  @Column(name = "expdate", unique = true, nullable = false)
  private String expdate;
  
  @Column(name = "salt")
  private String salt;


  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserRole> userRoles;

  

  
  
  public String getSalt() {
	    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }
  
  
     /**
   * Return the userId.
   * 
   * @return the userId
   */
  public int getUserId() {
    return userId;
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
   * Return the userRoles.
   * 
   * @return the userRoles
   */
  public Set<UserRole> getUserRoles() {
    return userRoles;
  }

  
  /**
   * Set the userId.
   * 
   * @param userId
   *          the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
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


  
  /**
   * Set the userRoles.
   * 
   * @param userRoles
   *          the userRoles to set
   */
  public void setUserRoles(Set<UserRole> userRoles) {
    this.userRoles = userRoles;
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

public String getOfficeNumber() {
	return officeNumber;
}

public void setOfficeNumber(String officeNumber) {
	this.officeNumber = officeNumber;
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

public String getCounty() {
	return county;
}

public void setCounty(String county) {
	this.county = county;
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

public String getExpdate() {
	return expdate;
}

public void setExpdate(String expdate) {
	this.expdate = expdate;
}



 
}
