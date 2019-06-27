package com.seedsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedsystem.common.model.RegisterRequest;
import com.seedsystem.common.model.RegisterResponse;
import com.seedsystem.common.util.AppConstants;
import com.seedsystem.common.util.AuthUtil;
import com.seedsystem.common.util.Encryptor;
import com.seedsystem.entity.User;
import com.seedsystem.repository.UserRepository;
import com.seedsystem.service.UserService;

@Service
@Transactional(transactionManager="seedsystemTransactionManager")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		
		//TODO Check if the user already exists , Can be a separate call later
		
		User user = new User();
		user.setUserName(registerRequest.getEmailUserId());
		user.setSalt(AuthUtil.generateSalt(10));
		
		String passwordWithSalt = registerRequest.getConfirmedPassword().concat(user.getSalt());
		user.setPassword(Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, passwordWithSalt));
		
		User savedUser = userRepository.save(user);
		
		RegisterResponse registerResponse = new RegisterResponse();
		registerResponse.setGeneratedUserId(savedUser.getUserId());
		
		return registerResponse;
	}

	

}
