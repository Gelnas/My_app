package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RateMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Rate toRate(RateDto rateDto);
}
