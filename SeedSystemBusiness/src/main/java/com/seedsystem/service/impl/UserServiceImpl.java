package com.seedsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedsystem.common.model.RegisterRequest;
import com.seedsystem.common.model.RegisterResponse;
import com.seedsystem.common.util.AppConstants;
import com.seedsystem.common.util.AuthUtil;
import com.seedsystem.common.util.Encryptor;
import com.seedsystem.entity.Farmer;
import com.seedsystem.repository.FarmerRepository;
import com.seedsystem.service.UserService;

@Service
@Transactional(transactionManager="seedsystemTransactionManager")
public class UserServiceImpl implements UserService {

	@Autowired
	private FarmerRepository farmerRepository;

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		
		RegisterResponse registerResponse = new RegisterResponse();
		//TODO Check if the user already exists , Can be a separate call later
		Farmer existingFarmer = farmerRepository.findByEmail(registerRequest.getEmail());
		if(existingFarmer != null) {
			registerResponse.setUserAlreadyExists(true);
			registerResponse.setUserRegisteredSuccessfully(false);
			return registerResponse;
		} else {
			
			Farmer farmer = new Farmer();
			farmer.setEmail(registerRequest.getEmail());
			farmer.setSalt(AuthUtil.generateSalt(10));
			farmer.setAddress(registerRequest.getAddress());
			farmer.setCity(registerRequest.getCity());
			farmer.setState(registerRequest.getState());
			farmer.setCreditCardNumber(registerRequest.getCreditCardNumber());
			farmer.setCvv(registerRequest.getCvv());
			farmer.setLastName(registerRequest.getLastName());
			farmer.setFirstName(registerRequest.getFirstName());
			farmer.setContactNumber(registerRequest.getContactNumber());
			farmer.setZip(registerRequest.getZip());
			String passwordWithSalt = registerRequest.getPassword().concat(farmer.getSalt());
			farmer.setPassword(Encryptor.encrypt(AppConstants.ENCRYPTION_KEY, AppConstants.ENCRYPTION_INIT_VECTOR, passwordWithSalt));
			Farmer savedFarmer = farmerRepository.save(farmer);
			registerResponse.setUserRegisteredSuccessfully(true);
			registerResponse.setRegisteredEmailId(savedFarmer.getEmail());
			
			return registerResponse;
		}
	}

	

}
