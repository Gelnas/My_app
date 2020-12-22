package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.request.CreateRateRequest;
import com.simbirsoft.my_app.model.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RateMapper {

    @Mapping(target = "id", ignore = true)

    Rate toRate(CreateRateRequest createRateRequest);
}
