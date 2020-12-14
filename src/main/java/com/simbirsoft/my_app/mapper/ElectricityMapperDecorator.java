package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Electricity;


public abstract class ElectricityMapperDecorator implements ElectricityMapper {
    private final ElectricityMapper electricityMapper;

    ElectricityMapperDecorator (ElectricityMapper electricityMapper){
        this.electricityMapper = electricityMapper;
    }

    @Override
    public Electricity toElectricity(ElectricityDto electricityDto, RateDto rateDto) {
        Electricity electricity = electricityMapper.toElectricity(electricityDto, rateDto);

        electricity.setScore(electricityDto.getCounter() * rateDto.getRateE());

        return electricity;
    }
}
