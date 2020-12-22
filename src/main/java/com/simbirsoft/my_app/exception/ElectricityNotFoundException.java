package com.simbirsoft.my_app.exception;

public class ElectricityNotFoundException extends RuntimeException {

    public ElectricityNotFoundException(Long id){
        super("There is not electricity with id: " + id);
    }
}
