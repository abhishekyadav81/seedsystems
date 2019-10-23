package com.seedsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
   * This method is used to get the account on the basis of State and County.
   *
   * @param userName
   *          {@link String}
   * @return User {@link User}
   */
  List<Dealer> findByStateAndCounty(String state,String county);
  
  @Query("Select dealer from Dealer dealer WHERE dealer.state=:state and dealer.county=:county and dealer.crop in(:listOfCrops)")
  List<Dealer> findByStateCountyAndCrops(@Param("state") String state, @Param("county") String county,
		  @Param("listOfCrops") List<String> listOfCrops);

  }
