package com.seedsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seedsystem.common.model.DealerResult;
import com.seedsystem.common.model.Response;
import com.seedsystem.common.model.SearchRequest;
import com.seedsystem.common.util.Messages;
import com.seedsystem.service.SearchService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testIt() {
		return "SEARCH SERVICE IS RUNNING";
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Encrypted hash value", dataType = "string", required = true, paramType = "header") })

	@RequestMapping(value = "/restricted", method = RequestMethod.GET)
	public String restrictedMethod() {
		return "Successful Response From Restricted Method";
	}

	@RequestMapping(value = "/dealer", method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
	@ApiOperation(value = "Search Api to find the Dealers")
	@ApiResponses({ @ApiResponse(code = 201, response = String.class, message = "Search Dealer Results returned Successfully"),
			@ApiResponse(code = 500, message = "Internal Error Occured"),
			@ApiResponse(code = 400, message = "Error in Request Data"), })
	public Response dealerSearch(@RequestBody(required = true) final SearchRequest searchRequest) {
		List<DealerResult> dealers = searchService.searchDealer(searchRequest);
		Response response =  new Response(HttpStatus.OK.value(), messages.get("OK"), dealers);
		return response;
	}

}
