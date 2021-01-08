package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.exception.PermissionNotFoundException;
import com.simbirsoft.my_app.model.Permission;
import com.simbirsoft.my_app.repository.PermissionRepository;
import com.simbirsoft.my_app.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public Permission getById(Long id) {

        return permissionRepository.findById(id).orElseThrow(() -> new PermissionNotFoundException(id));
    }
}
