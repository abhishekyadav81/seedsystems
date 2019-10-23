package com.seedsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public List<DealerResult> searchDealer(SearchRequest searchRequest) {
		List<Dealer> dealers = null;
		List<DealerResult> dealerResults = new ArrayList<DealerResult>();
		
		if(searchRequest.getCrops() != null && searchRequest.getCrops().size() > 0 ) {
			 dealers = dealerRepository.findByStateCountyAndCrops(searchRequest.getState(),
					 searchRequest.getCounty(),searchRequest.getCrops());
		} else {
			 dealers = dealerRepository.findByStateAndCounty(searchRequest.getState(),searchRequest.getCounty());
		}
		if(dealers !=null && dealers.size() > 0) {
			 
			dealers.forEach( dealer -> {
				DealerResult dealerResult = new DealerResult();
				dealerResult.setContactNumber(dealer.getContactNumber());
				dealerResult.setDealerTitle(dealer.getDealerTitle());
				dealerResult.setContactPerson(dealer.getContactPerson());
				dealerResults.add(dealerResult);
			});
		}
		return dealerResults;
	}

}
