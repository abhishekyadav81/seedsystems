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
  @Column(name = "dealername", unique = true, nullable = false)
  private String dealerName;

  @Column(name = "dealer number")
  private String dealerNumber;

  @Column(name = "dealer title", unique = true, nullable = false)
  private String dealerTitle;
  
  @Column(name = "state")
  private String state;
  
  @Column(name = "county")
  private String county;


  
  
  
  public String getState() {
	    return state;
  }
  
  public String getCounty() {
	    return county;
  }

  
  
  
     /**
   * Return the userId.
   * 
   * @return the userId
   */
  public String getDealerTitle() {
    return dealerTitle;
  }

  /**
   * Return the dateLastLogin.
   * 
   * @return the dateLastLogin
   */
  public String getDealerNumber() {
    return dealerNumber;
  }


  /**
   * Return the password.
   * 
   * @return the password
   */
  public String getDealerName() {
    return dealerName;
  }


  /**
   * Set the userId.
   * 
   * @param userId
   *          the userId to set
   */
  public void setDealerName(String dealerName) {
    this.dealerName = dealerName;
  }

  /**
   * Set the dateLastLogin.
   * 
   * @param dateLastLogin
   *          the dateLastLogin to set
   */
  public void setDealerNumber(String dealerNumber) {
    this.dealerNumber = dealerNumber;
  }



  /**
   * Set the password.
   * 
   * @param password
   *          the password to set
   */
  public void setDealerTitle(String dealerTitle) {
    this.dealerTitle = dealerTitle;
  }
  
  
  public void setState(String state) {
	    this.state = state;
  }
  
  
  /**
   * Set the password.
   * 
   * @param password
   *          the password to set
   */
  public void setCounty(String county) {
    this.county = county;
  }


  
  

 
}
