package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Rate;

public interface RateServiсe {

    Rate getById(Long id);
    void save(RateDto rateDto);
    void delete(Long id);

}
