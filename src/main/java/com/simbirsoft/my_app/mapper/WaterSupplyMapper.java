package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.WaterSupply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WaterSupplyMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "scoreHot", ignore = true),
            @Mapping(target = "scoreCold", ignore = true)
    })
    WaterSupply toWaterSupply(WaterSupplyDto waterSupplyDto);
}
