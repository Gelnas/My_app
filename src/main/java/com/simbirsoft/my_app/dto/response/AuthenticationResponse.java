package com.simbirsoft.my_app.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class AuthenticationResponse implements Serializable {

    private static long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
}
