package com.seedsystem.common.util;

import java.security.SecureRandom;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {
	
	
	  private static final Random RANDOM = new SecureRandom();
	  private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	  private static Logger logger = LoggerFactory.getLogger(AuthUtil.class);

	  /**
	   * This method is used to generate the random salt.
	   *
	   * @param length
	   *          length of generate Salt
	   * @return salt {@link String}
	   */
	  public static String generateSalt(int length) {
	    logger.info("Entered into generateSalt");
	    StringBuilder returnValue = new StringBuilder(length);

	    for (int i = 0; i < length; i++) {
	      returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	    }

	    logger.info("Exit from generateSalt");
	    return new String(returnValue);
	  }
	

}
