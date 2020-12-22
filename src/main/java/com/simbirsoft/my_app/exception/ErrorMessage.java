package com.simbirsoft.my_app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private final String status;
    private final String message;
}
