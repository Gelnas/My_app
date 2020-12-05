package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.model.Role;
import com.simbirsoft.my_app.repository.RoleRepository;
import com.simbirsoft.my_app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
