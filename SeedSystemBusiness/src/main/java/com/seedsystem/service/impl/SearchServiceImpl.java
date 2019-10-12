package com.seedsystem.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedsystem.common.model.DealerResult;
import com.seedsystem.common.model.RegisterRequest;
import com.seedsystem.common.model.RegisterResponse;
import com.seedsystem.common.model.SearchRequest;
import com.seedsystem.common.util.AppConstants;
import com.seedsystem.common.util.AuthUtil;
import com.seedsystem.common.util.Encryptor;
import com.seedsystem.entity.Dealer;
import com.seedsystem.entity.Farmer;
import com.seedsystem.entity.User;
import com.seedsystem.repository.DealerRepository;
import com.seedsystem.repository.FarmerRepository;
import com.seedsystem.repository.UserRepository;
import com.seedsystem.service.SearchService;
import com.seedsystem.service.UserService;

@Service
@Transactional(transactionManager="seedsystemTransactionManager")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DealerRepository dealerRepository;

	@Override
	public DealerResult searchDealer(SearchRequest searchRequest) {
		
		DealerResult dealerResult = new DealerResult();
		//TODO Check if the user already exists , Can be a separate call later
		Dealer dealers = dealerRepository.findbyStateAndCounty(searchRequest.getState());
		dealerResult.setDealerContact(dealers.getDealerName());
		dealerResult.setDealerName(dealers.getDealerTitle());
		dealerResult.setDealerPhone(dealers.getDealerNumber());
		
			
		return dealerResult;
		
	}

	

}
