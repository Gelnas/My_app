package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.Role;

/**
 * Service for working with {@link Role role} object
 */

public interface RoleService {

    /**
     * Method for finding a {@link Role role} by its id.
     * @param id - {@link Role role} unique identifier
     * @return {@link Role role} object with id like in arguments
     */
    Role getById(Long id);
}
