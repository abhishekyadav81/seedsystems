package com.seedsystem.service;

import com.seedsystem.common.model.SearchRequest;
import com.seedsystem.common.model.DealerResult;

public interface SearchService {

	public DealerResult searchDealer(SearchRequest searchRequest);

}
