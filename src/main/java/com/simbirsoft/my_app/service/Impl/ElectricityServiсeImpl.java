package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.mapper.ElectricityMapper;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElectricityServiсeImpl implements ElectricityServiсe {

    @Autowired
    private final ElectricityRepository electricityRepository;

    @Autowired
    private final ElectricityMapper electricityMapper;

    @Override
    public Electricity getById(Long id) {
        return electricityRepository.findById(id).orElse(null);
    }

    @Override
        public void save(ElectricityDto electDto, RateDto rateDto) {
        Electricity electricity = electricityMapper.toElectricity(electDto);
        electricity.setScore(electDto.getCounter() * rateDto.getRateE());
        electricityRepository.save(electricity);

}

    @Override
    public void delete(Long id) {
        electricityRepository.deleteById(id);
    }
}
