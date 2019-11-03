package com.seedsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedsystem.common.exception.NoSuchUserException;
import com.seedsystem.common.model.CachedAuthenticationDetails;
import com.seedsystem.common.model.LoginRequest;
import com.seedsystem.common.model.LoginResponse;
import com.seedsystem.common.util.AppConstants;
import com.seedsystem.common.util.CacheManager;
import com.seedsystem.common.util.Encryptor;
import com.seedsystem.common.util.JWTTokenUtil;
import com.seedsystem.entity.Farmer;
import com.seedsystem.entity.User;
import com.seedsystem.repository.FarmerRepository;
import com.seedsystem.repository.UserRepository;
import com.seedsystem.service.AuthenticationService;

@Service
@Transactional(transactionManager="seedsystemTransactionManager")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	//private UserRepository userRepository;
	private FarmerRepository farmerRepository;

/*	@Override
	public LoginResponse authenticate(LoginRequest loginRequest) throws NoSuchUserException {
		
		LoginResponse loginResponse = new LoginResponse(false);
		User user = userRepository.findByEmail(loginRequest.getEmailUserId());
		if(user == null) {
			throw new NoSuchUserException("User Id does not exist");
		} else {
			
			String encryptedPassword = Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, loginRequest.getPassword().concat(user.getSalt()));
			if(encryptedPassword.equals(user.getPassword())) {
				loginResponse.setAuthenticated(true);
				String jwtToken = jwtTokenUtil.generateToken(loginRequest.getEmailUserId()+user.getPassword()+user.getSalt());
				String encryptedJwtToken = Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, jwtToken);				
				
				loginResponse.setToken(encryptedJwtToken);
				
				CachedAuthenticationDetails authDetails = new CachedAuthenticationDetails(true);
				authDetails.setPassword(user.getPassword());
				authDetails.setSalt(user.getSalt());
				authDetails.setToken(jwtToken);
				authDetails.setUserName(user.getEmail());
				cacheManager.put(AppConstants.AUTHENTICATION_CACHE, jwtToken, authDetails);
				
			}
		}
		return loginResponse;
	}
*/	
	//TODO Remove Token from Cache in logout method
	
	
	@Override
	public LoginResponse authenticate(LoginRequest loginRequest) throws NoSuchUserException {
		
		LoginResponse loginResponse = new LoginResponse(false);
		Farmer user = farmerRepository.findByEmail(loginRequest.getEmailUserId());
		if(user == null) {
			throw new NoSuchUserException("User Id does not exist");
		} else {
			
			String encryptedPassword = Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, loginRequest.getPassword().concat(user.getSalt()));
			if(encryptedPassword.equals(user.getPassword())) {
				loginResponse.setAuthenticated(true);
				String jwtToken = jwtTokenUtil.generateToken(loginRequest.getEmailUserId()+user.getPassword()+user.getSalt());
				String encryptedJwtToken = Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, jwtToken);				
				
				loginResponse.setToken(encryptedJwtToken);
				
				CachedAuthenticationDetails authDetails = new CachedAuthenticationDetails(true);
				authDetails.setPassword(user.getPassword());
				authDetails.setSalt(user.getSalt());
				authDetails.setToken(jwtToken);
				authDetails.setUserName(user.getEmail());
				cacheManager.put(AppConstants.AUTHENTICATION_CACHE, jwtToken, authDetails);
				
			}
		}
		return loginResponse;
	}

}
