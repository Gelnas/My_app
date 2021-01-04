package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.Urls;
import com.simbirsoft.my_app.dto.request.AuthenticationRequest;
import com.simbirsoft.my_app.dto.response.AuthenticationResponse;
import com.simbirsoft.my_app.model.Users;
import com.simbirsoft.my_app.service.Impl.security.jwt.JwtTokenProvider;
import com.simbirsoft.my_app.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Urls.Authentication.FULL)
@RequiredArgsConstructor
@Api(tags = "Authentication")
public class AuthenticationRestControllerImpl {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    //@SneakyThrows
    @PostMapping
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        String username = request.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));

        String token = jwtTokenProvider.createToken(username);

        AuthenticationResponse response = new AuthenticationResponse(username,token);
        return ResponseEntity.ok(response);
    }
}
