package com.seedsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seedsystem.common.model.DealerResult;
import com.seedsystem.common.model.SearchRequest;
import com.seedsystem.entity.Dealer;
import com.seedsystem.repository.DealerRepository;
import com.seedsystem.service.SearchService;

@Service
@Transactional(transactionManager="seedsystemTransactionManager")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private DealerRepository dealerRepository;

	@Override
	public DealerResult searchDealer(SearchRequest searchRequest) {
		DealerResult dealerResult = new DealerResult();
		Dealer dealers = dealerRepository.findByStateAndCounty(searchRequest.getState(),searchRequest.getCounty());
		dealerResult.setDealerTitle(dealers.getDealerTitle());
		dealerResult.setContactPerson(dealers.getContactPerson());
		dealerResult.setContactNumber(dealers.getContactNumber());
		return dealerResult;
	}

}
