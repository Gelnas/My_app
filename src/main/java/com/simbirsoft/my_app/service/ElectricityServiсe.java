package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.request.CreateElectricityRequest;
import com.simbirsoft.my_app.model.Electricity;

public interface ElectricityServiсe {

    Electricity getById(Long id);
    void save(CreateElectricityRequest createElectricityRequest);
    void delete(Long id);

}
