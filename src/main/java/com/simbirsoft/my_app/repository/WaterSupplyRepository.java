package com.simbirsoft.my_app.repository;

import com.simbirsoft.my_app.model.WaterSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterSupplyRepository extends JpaRepository<WaterSupply, Long> {
}
