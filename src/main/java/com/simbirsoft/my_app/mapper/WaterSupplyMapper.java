package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.request.CreateWaterSupplyRequest;
import com.simbirsoft.my_app.dto.response.WaterSupplyResponse;
import com.simbirsoft.my_app.model.WaterSupply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WaterSupplyMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "scoreHot", expression = "java(createWaterSupplyRequest.getCounterHot() " +
                    "* createWaterSupplyRequest.getRateWH())"),
            @Mapping(target = "scoreCold", expression = "java(createWaterSupplyRequest.getCounterCold() " +
                    "* createWaterSupplyRequest.getRateWC())")

    })
    WaterSupply toWaterSupply(CreateWaterSupplyRequest createWaterSupplyRequest);

    WaterSupplyResponse toWaterSupplyResponse(WaterSupply waterSupply);
}
