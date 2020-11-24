package com.simbirsoft.my_app.repository;

import com.simbirsoft.my_app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
