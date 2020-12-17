package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Electricity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ElectricityMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "score", expression = "java(electricityDto.getCounter() * rateDto.getRateE())")
    })
    Electricity toElectricity(ElectricityDto electricityDto, RateDto rateDto);
}
