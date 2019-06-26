package com.seedsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class will act as a Parent class for all Entity classes.
 * 
 * @author Abhishek.Yadav
 * @since 05/2019
 */
@MappedSuperclass
public abstract class AbstractEntity {

  @Column(name = "modifiedby")
  private Integer modifiedBy;

  @Column(name = "createdby", nullable = false)
  private int createdBy;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "datemodified")
  private Date dateModified;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "datecreated", nullable = false)
  private Date dateCreated;

  /**
   * Return the modifiedBy.
   * 
   * @return the modifiedBy
   */
  public Integer getModifiedBy() {
    return modifiedBy;
  }

  /**
   * Return the createdBy.
   * 
   * @return the createdBy
   */
  public int getCreatedBy() {
    return createdBy;
  }

  /**
   * Return the dateModified.
   * 
   * @return the dateModified
   */
  public Date getDateModified() {
    return dateModified;
  }

  /**
   * Return the dateCreated.
   * 
   * @return the dateCreated
   */
  public Date getDateCreated() {
    return dateCreated;
  }

  /**
   * Set the modifiedBy.
   * 
   * @param modifiedBy
   *          the modifiedBy to set
   */
  public void setModifiedBy(Integer modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  /**
   * Set the createdBy.
   * 
   * @param createdBy
   *          the createdBy to set
   */
  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * Set the dateModified.
   * 
   * @param dateModified
   *          the dateModified to set
   */
  public void setDateModified(Date dateModified) {
    this.dateModified = dateModified;
  }

  /**
   * Set the dateCreated.
   * 
   * @param dateCreated
   *          the dateCreated to set
   */
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

}
