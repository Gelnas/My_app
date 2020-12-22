package com.simbirsoft.my_app.exception;

public class PermissionNotFoundException extends RuntimeException {

    public PermissionNotFoundException(Long id){
        super("There is not permission with id: " + id);
    }
}
