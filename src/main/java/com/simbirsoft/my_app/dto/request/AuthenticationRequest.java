package com.simbirsoft.my_app.dto.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private final String username;
    private final String password;
}
