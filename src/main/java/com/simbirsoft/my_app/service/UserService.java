package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.model.Role;
import com.simbirsoft.my_app.model.Users;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Service for working with {@link Users users} object
 */

public interface UserService {

    /**
     * Method for finding a {@link Users users} by its id.
     * @param id - {@link Users users} unique identifier
     * @return {@link Users users} object with id like in arguments
     */
    Users getById(Long id);

    void delete(Long id);

    Users findByUsername(String username);

    Collection<? extends GrantedAuthority> mapRolesToPermission(Collection<Role> roles);

    }
