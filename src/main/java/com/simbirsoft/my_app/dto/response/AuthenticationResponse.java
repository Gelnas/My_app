package com.simbirsoft.my_app.dto.response;

import lombok.Data;

@Data
public class AuthenticationResponse {

    private final String username;
    private final String token;
}
