package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.request.CreateElectricityRequest;
import com.simbirsoft.my_app.dto.response.ElectricityResponse;
import com.simbirsoft.my_app.model.Electricity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ElectricityMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "score", expression = "java(createElectricityRequest.getCounter() " +
                    "* createElectricityRequest.getRateE())")
    })
    Electricity toElectricity(CreateElectricityRequest createElectricityRequest);

    ElectricityResponse toElectricityResponse(Electricity electricity);
}
