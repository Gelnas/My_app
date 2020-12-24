package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.Expense;

/**
 * Service for working with {@link Expense expense} object
 */

public interface ExpenseServiсe {

    /**
     * Method for finding a {@link Expense expense} by its id.
     *
     * @param id - {@link Expense expense} unique identifier
     * @return {@link Expense expense} object with id like in arguments
     */

    Expense getById(Long id);

    /**
     * Method for adding new data {@link Expense expense} to the DB
     *
     * @param expense - {@link Expense expense} object
     * @return {@link Expense expense} object
     */

    Expense save(Expense expense);


    /**
     * Method to remove an object {@link Expense expense} from the DB
     *
     * @param id - {@link Expense expense} unique identifier
     */

    void delete(Long id);
}
