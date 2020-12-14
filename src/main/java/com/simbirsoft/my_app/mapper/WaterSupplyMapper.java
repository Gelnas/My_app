package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.WaterSupply;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper()
@DecoratedWith(WaterSupplyMapperDecorator.class)
public interface WaterSupplyMapper {

    WaterSupplyMapper INSTANCE = Mappers.getMapper(WaterSupplyMapper.class);
    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    WaterSupply toWaterSupply(WaterSupplyDto waterSupplyDto, RateDto rateDto);
}
