package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.WaterSupply;

/**
 * Service for working with {@link WaterSupply waterSupply} object
 */

public interface WaterSupplyServiсe {

    /**
     * Method for finding a {@link WaterSupply waterSupply} by its id.
     *
     * @param id - {@link WaterSupply waterSupply} unique identifier
     * @return {@link WaterSupply waterSupply} object with id like in arguments
     */

    WaterSupply getById(Long id);

    /**
     * Method for adding new data {@link WaterSupply waterSupply} to the DB
     *
     * @param waterSupply -{@link WaterSupply waterSupply} object
     * @return {@link WaterSupply waterSupply} object
     */

    WaterSupply save(WaterSupply waterSupply);

    /**
     * Method to remove an object {@link WaterSupply waterSupply} from the DB
     *
     * @param id - {@link WaterSupply waterSupply} unique identifier
     */

    void delete(Long id);

}
