package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.WaterSupply;

public interface WaterSupplyServiсe {

    WaterSupply getById(Long id);
    void save(WaterSupplyDto waterSupplyDto, RateDto rateDto);
    void delete(Long id);

}
