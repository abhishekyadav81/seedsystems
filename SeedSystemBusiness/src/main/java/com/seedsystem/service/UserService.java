package com.seedsystem.service;

import com.seedsystem.common.model.RegisterRequest;
import com.seedsystem.common.model.RegisterResponse;

public interface UserService {

	public RegisterResponse register(RegisterRequest registerRequest);

}
