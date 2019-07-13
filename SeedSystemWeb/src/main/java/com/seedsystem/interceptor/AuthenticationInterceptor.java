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
import com.seedsystem.common.model.LoginResponse;
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
      httpServletResponse.setStatus(401);
      throw new SeedSystemException(HttpStatus.UNAUTHORIZED, "Access Denied");

    } else {

      String encryptedTokenFromClient = httpServletRequest.getHeader("Authorization"); 
      //Decrypt the JWt Token
      
      String jwtToken = Encryptor.decrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, encryptedTokenFromClient);
      
      LoginResponse loginResponse = cacheManager.get(AppConstants.AUTHENTICATION_CACHE, jwtToken, LoginResponse.class); 
      
      if (loginResponse == null || !jwtTokenUtil.validateToken(jwtToken,loginResponse.getUserName())) {
    	  logger.error("Invalid Token, Object not found in Cache");
          throw new SeedSystemException(HttpStatus.UNAUTHORIZED, "Access Denied");
        }
      } 
    
    logger.info("Exit from preHandle");
    return true;
  }

}
