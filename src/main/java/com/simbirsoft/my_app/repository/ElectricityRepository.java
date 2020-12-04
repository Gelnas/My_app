package com.simbirsoft.my_app.repository;

import com.simbirsoft.my_app.model.Electricity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityRepository extends JpaRepository<Electricity, Long> {

}
