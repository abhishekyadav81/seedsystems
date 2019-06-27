package com.seedsystem.service;

import com.seedsystem.common.exception.NoSuchUserException;
import com.seedsystem.common.model.LoginRequest;
import com.seedsystem.common.model.LoginResponse;

public interface AuthenticationService {

	LoginResponse authenticate(LoginRequest loginRequest) throws NoSuchUserException;

}
