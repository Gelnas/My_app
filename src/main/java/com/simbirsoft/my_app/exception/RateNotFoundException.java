package com.simbirsoft.my_app.exception;

public class RateNotFoundException extends RuntimeException{

    public RateNotFoundException(Long id){
        super("There is not rate with id: " + id);
    }
}
