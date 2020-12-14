package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Electricity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper()
@DecoratedWith(ElectricityMapperDecorator.class)
public interface ElectricityMapper {

    ElectricityMapper INSTANCE = Mappers.getMapper(ElectricityMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Electricity toElectricity(ElectricityDto electricityDto, RateDto rateDto);
}
