package com.seedsystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seedsystem.common.exception.SeedSystemException;
import com.seedsystem.common.model.CachedAuthenticationDetails;
import com.seedsystem.common.util.AppConstants;
import com.seedsystem.common.util.CacheManager;
import com.seedsystem.common.util.Encryptor;
import com.seedsystem.common.util.JWTTokenUtil;

/**
 * Request Interceptor for all request coming from client to check for authentication.
 *
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

  @Value("${session.timeout}")
  private int sessionTimeout;

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private JWTTokenUtil jwtTokenUtil;
  
  @Autowired
  private CacheManager cacheManager;


  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o) throws Exception {
    logger.info("Entered into preHandle");
    if (httpServletRequest.getHeader("Authorization") == null) {
      logger.error("Invalid header parameters");
      throw new SeedSystemException(HttpStatus.UNAUTHORIZED, "Access Denied");

    } else {

      String encryptedTokenFromClient = httpServletRequest.getHeader("Authorization");
      String jwtToken = null;
      //Decrypt the JWt Token
      try {
    	   jwtToken = Encryptor.decrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, encryptedTokenFromClient);
      } catch(SeedSystemException ex) {
    	  throw new SeedSystemException(HttpStatus.UNAUTHORIZED, "Access Denied Invalid Auth Header");      }
      
      CachedAuthenticationDetails cachedAuth = cacheManager.get(AppConstants.AUTHENTICATION_CACHE, jwtToken, CachedAuthenticationDetails.class); 
      
      if (cachedAuth == null || !jwtTokenUtil.validateToken(jwtToken,cachedAuth.getUserName()+cachedAuth.getPassword()+cachedAuth.getSalt())) {
    	  logger.error("Invalid Token, Object not found in Cache");
          throw new SeedSystemException(HttpStatus.UNAUTHORIZED, "Access Denied Invalid Token");
        }
      } 
    
    logger.info("Exit from preHandle");
    return true;
  }

}
