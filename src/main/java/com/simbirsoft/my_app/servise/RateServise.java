package com.simbirsoft.my_app.servise;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.Rate;

public interface RateServise {

    Rate getById(Long id);
    void save(RateDto rateDto);
    void delete(Long id);

}
