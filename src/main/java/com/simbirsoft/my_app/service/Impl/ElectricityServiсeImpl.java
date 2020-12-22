package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.request.CreateElectricityRequest;
import com.simbirsoft.my_app.exception.ElectricityNotFoundException;
import com.simbirsoft.my_app.mapper.ElectricityMapper;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class ElectricityServiсeImpl implements ElectricityServiсe {


    private ElectricityRepository electricityRepository;
    private ElectricityMapper electricityMapper;

    @Transactional(readOnly = true)
    @Override
    public Electricity getById(Long id) {
        Assert.notNull(id, "Electricity id should not be null");
        return electricityRepository.findById(id).orElseThrow(() -> new ElectricityNotFoundException(id));
    }

    @Override
        public void save(CreateElectricityRequest createElectricityRequest) {
        Assert.notNull(createElectricityRequest, "Electricity dto should not be null");
        electricityRepository.save(electricityMapper.toElectricity(createElectricityRequest));
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Electricity id should not be null");
        Electricity electricity = electricityRepository.findById(id).orElseThrow(() -> new ElectricityNotFoundException(id));
        electricityRepository.delete(electricity);
    }
}
