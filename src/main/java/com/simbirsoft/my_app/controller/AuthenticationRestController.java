package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.request.AuthenticationRequest;
import com.simbirsoft.my_app.dto.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.naming.AuthenticationException;

public interface AuthenticationRestController {
    ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws AuthenticationException;
    }
