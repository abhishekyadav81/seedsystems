package com.seedsystem.service;

import com.seedsystem.common.RegisterResponse;
import com.seedsystem.common.model.RegisterRequest;

public interface UserService {

	public RegisterResponse register(RegisterRequest registerRequest);

}
