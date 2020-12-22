package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.request.CreateWaterSupplyRequest;
import com.simbirsoft.my_app.model.WaterSupply;

public interface WaterSupplyServiсe {

    WaterSupply getById(Long id);
    void save(CreateWaterSupplyRequest createWaterSupplyRequest);
    void delete(Long id);

}
