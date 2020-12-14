package com.simbirsoft.my_app.mapper;


import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.WaterSupply;
import org.mapstruct.Mapping;

public abstract class WaterSupplyMapperDecorator implements WaterSupplyMapper {
    private final WaterSupplyMapper waterSupplyMapper;

    WaterSupplyMapperDecorator (WaterSupplyMapper waterSupplyMapper){
        this.waterSupplyMapper = waterSupplyMapper;
    }

    @Override
    public WaterSupply toWaterSupply(WaterSupplyDto waterSupplyDto, RateDto rateDto) {
        WaterSupply waterSupply = waterSupplyMapper.toWaterSupply(waterSupplyDto, rateDto);

        waterSupply.setScoreHot(waterSupplyDto.getCounterHot() * rateDto.getRateWH());
        waterSupply.setScoreCold(waterSupplyDto.getCounterCold() * rateDto.getRateWC());

        return waterSupply;
    }
}
