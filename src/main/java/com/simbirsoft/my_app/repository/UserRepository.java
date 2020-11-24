package com.simbirsoft.my_app.repository;

import com.simbirsoft.my_app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
