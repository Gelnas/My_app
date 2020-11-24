package com.simbirsoft.my_app.repository;

import com.simbirsoft.my_app.model.Role;
import com.simbirsoft.my_app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role_);

}
