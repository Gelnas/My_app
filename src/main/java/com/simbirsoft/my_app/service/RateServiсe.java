package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.request.CreateRateRequest;
import com.simbirsoft.my_app.model.Rate;

public interface RateServiсe {

    Rate getById(Long id);
    void save(CreateRateRequest createRateRequest);
    void delete(Long id);

}
