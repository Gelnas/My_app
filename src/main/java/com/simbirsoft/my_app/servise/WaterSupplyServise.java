package com.simbirsoft.my_app.servise;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.WaterSupply;

public interface WaterSupplyServise {

    WaterSupply getById(Long id);
    void save(WaterSupplyDto waterSupplyDto, RateDto rateDto);
    void delete(Long id);

}
