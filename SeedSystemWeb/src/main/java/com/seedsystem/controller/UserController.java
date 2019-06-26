package com.seedsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seedsystem.common.RegisterResponse;
import com.seedsystem.common.model.LoginRequest;
import com.seedsystem.common.model.LoginResponse;
import com.seedsystem.common.model.RegisterRequest;
import com.seedsystem.common.model.Response;
import com.seedsystem.common.util.Messages;
import com.seedsystem.service.AuthenticationService;
import com.seedsystem.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private Messages messages;
	
	@RequestMapping(value="/test")
	public String testIt() {
		return "IT IS RUNNING";
	}
	
	  @RequestMapping(value = "/login", method = RequestMethod.POST,
		      produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
		  @ApiOperation(value = "Login Api for User")
		  @ApiResponses({
		      @ApiResponse(code = 201, response = String.class, message = "User logged in Successfully"),
		      @ApiResponse(code = 500, message = "Internal Error Occured"),
		      @ApiResponse(code = 400, message = "Error in Request Data"),
		  })
	public Response login (@RequestBody(required = true) final LoginRequest loginRequest,
		      @RequestHeader("X-Origin") String clientHostName) {

		  LoginResponse response = authService.authenticate(loginRequest);
		  
		  if(response.getAuthenticated()) {
			  return new Response(HttpStatus.OK.value(), messages.get("AUTHENTICATION_SUCCESSFUL"), response);
		  } else {
			  return new Response(HttpStatus.UNAUTHORIZED.value(), messages.get("AUTHENTICATION_FAILURE"), response);
		  }
		
	}
	
	  @RequestMapping(value = "/register", method = RequestMethod.POST,
		      produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
		  @ApiOperation(value = "Register Api for User")
		  @ApiResponses({
		      @ApiResponse(code = 201, response = String.class, message = "User logged in Successfully"),
		      @ApiResponse(code = 500, message = "Internal Error Occured"),
		      @ApiResponse(code = 400, message = "Error in Request Data"),})
	  public Response login (@RequestBody(required = true) final RegisterRequest registerRequest,
		      @RequestHeader("X-Origin") String clientHostName) {

		  RegisterResponse response = userService.register(registerRequest);
		  
		  if(response.getSuccessful()) {
			  return new Response(HttpStatus.CREATED.value(), messages.get("REGISTRATION_SUCCESSFUL"), response);
		  } else {
			  return new Response(HttpStatus.UNAUTHORIZED.value(), messages.get("REGISTRATION_FAILED"), response);
		  }
	}
	
	
}
