package com.simbirsoft.my_app.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class AuthenticationRequest  {

        private static long serialVersionUID = 5926468583005150707L;
        private final String username;
        private final String password;

}
