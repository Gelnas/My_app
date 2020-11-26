package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.model.Permission;
import com.simbirsoft.my_app.model.Role;
import com.simbirsoft.my_app.repository.PermissionRepository;
import com.simbirsoft.my_app.repository.RoleRepository;
import com.simbirsoft.my_app.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission getById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }
}
