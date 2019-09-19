package com.seedsystem.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedsystem.common.model.RegisterRequest;
import com.seedsystem.common.model.RegisterResponse;
import com.seedsystem.common.util.AppConstants;
import com.seedsystem.common.util.AuthUtil;
import com.seedsystem.common.util.Encryptor;
import com.seedsystem.entity.Farmer;
import com.seedsystem.entity.User;
import com.seedsystem.repository.FarmerRepository;
import com.seedsystem.repository.UserRepository;
import com.seedsystem.service.UserService;

@Service
@Transactional(transactionManager="seedsystemTransactionManager")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FarmerRepository farmerRepository;

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		
		RegisterResponse registerResponse = new RegisterResponse();
		//TODO Check if the user already exists , Can be a separate call later
		User existingUser = userRepository.findByEmail(registerRequest.getEmailUserId());
		if(existingUser != null) {
			registerResponse.setUserAlreadyExists(true);
			registerResponse.setUserRegisteredSuccessfully(false);
			return registerResponse;
		} else {
			
			Farmer farmer = new Farmer();
			farmer.setEmail(registerRequest.getEmailUserId());
			farmer.setSalt(AuthUtil.generateSalt(10));
			farmer.setAddress(registerRequest.getAddress());
			farmer.setCity(registerRequest.getCity());
			farmer.setCreditCardNumber(registerRequest.getCreditCardNumber());
			farmer.setCvv(registerRequest.getCvv());
			farmer.setLastName(registerRequest.getLastName());
			farmer.setFirstName(registerRequest.getFirstName());
			farmer.setOfficeNumber(registerRequest.getContactNumber());
			farmer.setZip(registerRequest.getZip());
			
			String passwordWithSalt = registerRequest.getConfirmedPassword().concat(farmer.getSalt());
			farmer.setPassword(Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, passwordWithSalt));
			
			Farmer savedFarmer = farmerRepository.save(farmer);
			registerResponse.setGeneratedUserId(savedFarmer.getUserId());
			registerResponse.setUserRegisteredSuccessfully(true);
			
			/*User user = new User();
			user.setEmail(registerRequest.getEmailUserId());
			user.setSalt(AuthUtil.generateSalt(10));
			user.setDateLoginCreatedOn(Calendar.getInstance().getTime());
			
			String passwordWithSalt = registerRequest.getConfirmedPassword().concat(user.getSalt());
			user.setPassword(Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, passwordWithSalt));
			
			User savedUser = userRepository.save(user);
			registerResponse.setGeneratedUserId(savedUser.getUserId());
			registerResponse.setUserRegisteredSuccessfully(true);*/
			
			return registerResponse;
		}
	}

	

}
