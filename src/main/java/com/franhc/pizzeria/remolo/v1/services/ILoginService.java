package com.franhc.pizzeria.remolo.v1.services;

import com.franhc.pizzeria.remolo.v1.payloads.requests.AuthResponse;
import com.franhc.pizzeria.remolo.v1.payloads.requests.LoginRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.RegisterRequest;

public interface ILoginService {

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterRequest registerRequest);

}

