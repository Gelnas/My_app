package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.Rate;

/**
 * Service for working with {@link Rate rate} object
 */

public interface RateServiсe {

    /**
     * Method for finding a {@link Rate rate}} by its id.
     * @param id - {@link Rate rate} unique identifier
     * @return {@link Rate rate} object with id like in arguments
     */
    Rate getById(Long id);

    /**
     * Method for adding new data {@link Rate rate} to the DB
     * @param rate - {@link Rate rate} object
     * @return {@link Rate rate} object
     */
    Rate save(Rate rate);

    /**
     * Method to remove an object {@link Rate rate} from the DB
     * @param id - {@link Rate rate} unique identifier
     */
    void delete(Long id);

}
