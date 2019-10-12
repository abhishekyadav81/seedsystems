package com.seedsystem.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seedsystem.entity.Dealer;
import com.seedsystem.entity.User;



/**
 * This Class is responsible for handling database operation related to Dealer entity.
 *
 * @author Saurabh.Prakash
 * @see {@link User}
 * @see {@link CrudRepository}
 * @since 05/2019.
 */
@Repository
public interface DealerRepository extends CrudRepository<Dealer, Integer> {

  /**
   * This method is used to get the account on the basis of Email.
   *
   * @param userName
   *          {@link String}
   * @return User {@link User}
   */
  Dealer findbyStateAndCounty(String emailId);

  }
