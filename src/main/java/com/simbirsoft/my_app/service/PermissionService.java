package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.Permission;

/**
 * Service for working with {@link Permission permission} object
 */

public interface PermissionService {

    /**
     * Method for finding a {@link Permission permission} by its id.
     *
     * @param id - {@link Permission permission} unique identifier
     * @return {@link Permission permission} object with id like in arguments
     */

    Permission getById(Long id);
}
