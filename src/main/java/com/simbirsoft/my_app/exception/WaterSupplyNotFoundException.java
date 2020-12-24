package com.simbirsoft.my_app.exception;

public class WaterSupplyNotFoundException extends RuntimeException {

    public WaterSupplyNotFoundException(Long id){
        super("There is not water supply with id: " + id);
    }
}
