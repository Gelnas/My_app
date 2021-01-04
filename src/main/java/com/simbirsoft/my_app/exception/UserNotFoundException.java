package com.simbirsoft.my_app.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("There is not user with id: " + id);
    }

    public UserNotFoundException(String username){
        super("There is not user with username: " + username);
    }

}
