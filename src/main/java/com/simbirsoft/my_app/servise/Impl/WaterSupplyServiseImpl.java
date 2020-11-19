package com.simbirsoft.my_app.servise.Impl;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.repository.WaterSupplyRepository;
import com.simbirsoft.my_app.servise.WaterSupplyServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterSupplyServiseImpl implements WaterSupplyServise {

    @Autowired
    private WaterSupplyRepository waterSupplyRepository;

    @Override
    public WaterSupply getById(Long id) {
        return waterSupplyRepository.findById(id).orElse(null);
    }

    @Override
    public void save(WaterSupplyDto waterSupplyDto, RateDto rateDto) {

        WaterSupply waterSupply = new WaterSupply();

        waterSupply.setDate(waterSupplyDto.getDate());
        waterSupply.setCounterCold(waterSupplyDto.getCounterCold());
        waterSupply.setCounterHot(waterSupplyDto.getCounterHot());
        waterSupply.setScoreCold(waterSupplyDto.getCounterCold() * rateDto.getRateWC());
        waterSupply.setScoreHot(waterSupplyDto.getCounterHot() * rateDto.getRateWH());

        waterSupplyRepository.save(waterSupply);
    }

    @Override
    public void delete(Long id) {
        waterSupplyRepository.deleteById(id);
    }
}
