package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.exception.ElectricityNotFoundException;
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


    @Transactional(readOnly = true)
    @Override
    public Electricity getById(Long id) {
        Assert.notNull(id, "Electricity id should not be null");
        return electricityRepository.findById(id).orElseThrow(() -> new ElectricityNotFoundException(id));
    }

    @Override
        public Electricity save(Electricity electricity) {
        Assert.notNull(electricity, "Electricity should not be null");
        return  electricityRepository.save(electricity);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Electricity id should not be null");
        Electricity electricity = electricityRepository.findById(id).orElseThrow(() -> new ElectricityNotFoundException(id));
        electricityRepository.delete(electricity);
    }
}
