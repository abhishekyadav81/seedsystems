package com.seedsystem.service;

import com.seedsystem.common.model.SearchRequest;

import java.util.List;

import com.seedsystem.common.model.DealerResult;

public interface SearchService {

	public List<DealerResult> searchDealer(SearchRequest searchRequest);

}
