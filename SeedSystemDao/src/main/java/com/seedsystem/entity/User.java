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
@Table(name = "User.User")

public class User {//extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", unique = true, nullable = false)
  private int userId;

  @Column(name = "username")
  private String userName;
  
  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;
  
  @Column(name = "salt")
  private String salt;

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }



  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserRole> userRoles;

  

  @Column(name = "created_on")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateLoginCreatedOn;

  @Column(name = "last_login")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateLastLogin;
  
  
     /**
   * Return the userId.
   * 
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * Return the dateLastLogin.
   * 
   * @return the dateLastLogin
   */
  public Date getDateLastLogin() {
    return dateLastLogin;
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
   * Return the userName.
   * 
   * @return the userName
   */
  public String getUserName() {
    return userName;
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
   * Set the dateLastLogin.
   * 
   * @param dateLastLogin
   *          the dateLastLogin to set
   */
  public void setDateLastLogin(Date dateLastLogin) {
    this.dateLastLogin = dateLastLogin;
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
   * Set the userName.
   * 
   * @param userName
   *          the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
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

 
}
