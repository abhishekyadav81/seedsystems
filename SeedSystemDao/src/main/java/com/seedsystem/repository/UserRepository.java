package com.seedsystem.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seedsystem.entity.User;



/**
 * This Class is responsible for handling database operation related to User entity.
 *
 * @author Abhishek.Yadav
 * @see {@link User}
 * @see {@link CrudRepository}
 * @since 05/2019.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  /**
   * This method is used to get the account on the basis of Email.
   *
   * @param userName
   *          {@link String}
   * @return User {@link User}
   */
  User findByEmail(String emailId);

  /**
   * This method is used to fetch User by Id on the basis of Entity graph.
   * NOTE: This method will load userRoles eagerly.
   * 
   * @param userId
   *          {@link Integer}
   * @return {@link User}
   */
  @EntityGraph(attributePaths = { "userRoles" })
  User findByUserId(int userId);
}
