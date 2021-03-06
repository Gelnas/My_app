package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.mapper.WaterSupplyMapper;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.repository.WaterSupplyRepository;
import com.simbirsoft.my_app.service.WaterSupplyServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class WaterSupplyServiсeImpl implements WaterSupplyServiсe {

    @Autowired
    private WaterSupplyRepository waterSupplyRepository;

    @Autowired
    private WaterSupplyMapper waterSupplyMapper;

    @Override
    public WaterSupply getById(Long id) {
        return waterSupplyRepository.findById(id).orElse(null);
    }

    @Override
    public void save(WaterSupplyDto waterSupplyDto, RateDto rateDto) {

        WaterSupply waterSupply = waterSupplyMapper.toWaterSupply(waterSupplyDto);
        waterSupply.setScoreHot(waterSupplyDto.getCounterHot() * rateDto.getRateWH());
        waterSupply.setScoreCold(waterSupplyDto.getCounterCold() * rateDto.getRateWC());
        waterSupplyRepository.save(waterSupply);
    }

    @Override
    public void delete(Long id) {
        waterSupplyRepository.deleteById(id);
    }
}
