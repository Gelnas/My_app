package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.Electricity;


/**
 * Service for working with {@link Electricity electricity} entity
 */
public interface ElectricityServiсe {

    /**
     * Method for finding a {@link Electricity electricity} by its id.
     *
     * @param id - {@link Electricity electricity} unique identifier
     * @return {@link Electricity electricity} object with id like in arguments
     */

    Electricity getById(Long id);

    /**
     * Method for adding new data {@link Electricity electricity} to the DB
     *
     * @param electricity - {@link Electricity electricity} object
     * @return {@link Electricity electricity} object
     */

    Electricity save(Electricity electricity);

    /**
     * Method to remove an object {@link Electricity electricity} from the DB
     *
     * @param id - {@link Electricity electricity} unique identifier
     */

    void delete(Long id);

}
