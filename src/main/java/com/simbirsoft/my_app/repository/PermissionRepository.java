package com.simbirsoft.my_app.repository;

import com.simbirsoft.my_app.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
