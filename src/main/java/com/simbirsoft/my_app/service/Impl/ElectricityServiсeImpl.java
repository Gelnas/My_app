package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.mapper.ElectricityMapper;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class ElectricityServiсeImpl implements ElectricityServiсe {


    private ElectricityRepository electricityRepository;
    private ElectricityMapper electricityMapper;

    @Override
    public Electricity getById(Long id) {
        return electricityRepository.findById(id).orElse(null);
    }

    @Override
        public void save(ElectricityDto electDto, RateDto rateDto) {
        electricityRepository.save(electricityMapper.toElectricity(electDto, rateDto));

}

    @Override
    public void delete(Long id) {
        electricityRepository.deleteById(id);
    }
}
