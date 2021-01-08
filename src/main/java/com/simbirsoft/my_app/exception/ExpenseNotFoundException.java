package com.simbirsoft.my_app.exception;

public class ExpenseNotFoundException extends RuntimeException{

    public ExpenseNotFoundException(Long id){
        super("There is not expense with id: " + id);
    }
}
