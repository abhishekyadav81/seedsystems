package com.seedsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedsystem.common.exception.NoSuchUserException;
import com.seedsystem.common.model.LoginRequest;
import com.seedsystem.common.model.LoginResponse;
import com.seedsystem.common.util.AppConstants;
import com.seedsystem.common.util.Encryptor;
import com.seedsystem.entity.User;
import com.seedsystem.repository.UserRepository;
import com.seedsystem.service.AuthenticationService;

@Service
@Transactional(transactionManager="seedsystemTransactionManager")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public LoginResponse authenticate(LoginRequest loginRequest) throws NoSuchUserException {
		
		LoginResponse loginResponse = new LoginResponse(false);
		User user = userRepository.findByEmail(loginRequest.getEmailUserId());
		if(user == null) {
			throw new NoSuchUserException("User Id does not exist");
		} else {
			
			String encryptedPassword = Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, loginRequest.getPassword().concat(user.getSalt()));
			if(encryptedPassword.equals(user.getPassword())) {
				loginResponse.setAuthenticated(true);
			}
		}
		return loginResponse;
	}

}
