package com.franhc.pizzeria.remolo.v1.controllers.impl;

import com.franhc.pizzeria.remolo.v1.controllers.IAuthController;
import com.franhc.pizzeria.remolo.v1.payloads.requests.AuthResponse;
import com.franhc.pizzeria.remolo.v1.payloads.requests.LoginRequest;
import com.franhc.pizzeria.remolo.v1.payloads.requests.RegisterRequest;
import com.franhc.pizzeria.remolo.v1.services.impl.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements IAuthController {

    private final Log log = LogFactory.getLog(AuthController.class);

    @Autowired
    private LoginService loginService;

    @Override
    public ResponseEntity<AuthResponse> login(LoginRequest loginRequest) {
        log.info("... running AuthController.login ...");
        return new ResponseEntity<>(loginService.login(loginRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AuthResponse> register(RegisterRequest registerRequest) {
        log.info("... running AuthController.register ...");
        return new ResponseEntity<>(loginService.register(registerRequest), HttpStatus.OK);
    }
}
