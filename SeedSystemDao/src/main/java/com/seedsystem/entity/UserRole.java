package com.seedsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 */
@Entity
@Table(name = "userrole", schema="usernew")
public class UserRole {//extends AbstractEntity {
  
  
  @Embeddable
  private static class UserRolePK implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 5435306522278538609L;

    @Column(name = "user_id", unique = true, nullable = false)
    private int userId;

    @Column(name = "role_id", unique = true, nullable = false)
    private int roleId;
    
  }

  @EmbeddedId
  private UserRolePK userRoleId;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false,insertable=false,updatable=false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", nullable = false,insertable=false,updatable=false)
  private Role role;

  @Column(name = "grant_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date grantDate;


  
  public UserRolePK getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(UserRolePK userRoleId) {
    this.userRoleId = userRoleId;
  }

  public Date getGrantDate() {
    return grantDate;
  }

  public void setGrantDate(Date grantDate) {
    this.grantDate = grantDate;
  }

  /**
   * Return the user.
   * 
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * Set the user.
   * 
   * @param user
   *          the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }
  
  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
  

}
