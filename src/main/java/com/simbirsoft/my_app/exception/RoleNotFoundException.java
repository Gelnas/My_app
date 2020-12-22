package com.simbirsoft.my_app.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(Long id){
        super("There is not role with id: " + id);
    }
}
