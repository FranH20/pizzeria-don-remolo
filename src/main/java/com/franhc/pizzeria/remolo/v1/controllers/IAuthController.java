package com.franhc.pizzeria.remolo.v1.controllers;

import com.franhc.pizzeria.remolo.v1.payloads.requests.AuthResponse;
import com.franhc.pizzeria.remolo.v1.payloads.requests.LoginRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.RegisterRequest;
import com.franhc.pizzeria.remolo.v1.util.Constants;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("api/v1/auth")
@Tag(name = Constants.AUTH_TAG, description = "The auth API")
public interface IAuthController {

    @PostMapping("/login")
    ResponseEntity<AuthResponse> login(
            @Parameter(description = "Login to use the Api", required = true)
            @Valid @RequestBody LoginRequest loginRequest);

    @PostMapping("/register")
    ResponseEntity<AuthResponse> register(
            @Parameter(description = "Register to use the Api", required = true)
            @Valid @RequestBody RegisterRequest registerRequest);

}
