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

    public WaterSupplyServiсeImpl() {
    }

    public WaterSupplyServiсeImpl(WaterSupplyRepository waterSupplyRepository, WaterSupplyMapper waterSupplyMapper) {
        this.waterSupplyRepository = waterSupplyRepository;
        this.waterSupplyMapper = waterSupplyMapper;
    }

    @Override
    public WaterSupply getById(Long id) {
        return waterSupplyRepository.findById(id).orElse(null);
    }

    @Override
    public void save(WaterSupplyDto waterSupplyDto, RateDto rateDto) {
        waterSupplyRepository.save(waterSupplyMapper.toWaterSupply(waterSupplyDto, rateDto));
    }

    @Override
    public void delete(Long id) {
        waterSupplyRepository.deleteById(id);
    }
}
