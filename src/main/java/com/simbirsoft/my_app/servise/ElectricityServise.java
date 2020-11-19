package com.simbirsoft.my_app.servise;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Electricity;

public interface ElectricityServise {

    Electricity getById(Long id);
    void save(ElectricityDto electricityDto, RateDto rateDto);
    void delete(Long id);

}
