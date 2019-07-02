package com.seedsystem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 
 * 
 */
@Entity
@Table(name = "role", schema="usernew")
public class Role {//extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id", unique = true, nullable = false)
  private int roleId;

  
  @Column(name = "role_desc")
  private String roleDesc;

  @Column(name = "role_name")
  private String roleName;

  
  @OneToMany(mappedBy = "role")
  private Set<UserRole> userRoles;

  
  /**
   * Return the roleId.
   * 
   * @return the roleId
   */
  public int getRoleId() {
    return roleId;
  }

  /**
   * Return the roleDesc.
   * 
   * @return the roleDesc
   */
  public String getRoleDesc() {
    return roleDesc;
  }

  /**
   * Return the roleName.
   * 
   * @return the roleName
   */
  public String getRoleName() {
    return roleName;
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
   * Set the roleId.
   * 
   * @param roleId
   *          the roleId to set
   */
  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }


  /**
   * Set the roleDesc.
   * 
   * @param roleDesc
   *          the roleDesc to set
   */
  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }

  /**
   * Set the roleName.
   * 
   * @param roleName
   *          the roleName to set
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
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
