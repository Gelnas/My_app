package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.WaterSupply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WaterSupplyMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "scoreHot", expression = "java(waterSupplyDto.getCounterHot() * rateDto.getRateWH())"),
            @Mapping(target = "scoreCold", expression = "java(waterSupplyDto.getCounterCold() * rateDto.getRateWC())")

    })

    WaterSupply toWaterSupply(WaterSupplyDto waterSupplyDto, RateDto rateDto);
}
