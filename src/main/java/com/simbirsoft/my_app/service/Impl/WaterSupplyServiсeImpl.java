package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.request.CreateWaterSupplyRequest;
import com.simbirsoft.my_app.exception.WaterSupplyNotFoundException;
import com.simbirsoft.my_app.mapper.WaterSupplyMapper;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.repository.WaterSupplyRepository;
import com.simbirsoft.my_app.service.WaterSupplyServiсe;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class WaterSupplyServiсeImpl implements WaterSupplyServiсe {

    @Autowired
    private WaterSupplyRepository waterSupplyRepository;

    @Autowired
    private WaterSupplyMapper waterSupplyMapper;

    @Transactional(readOnly = true)
    @Override
    public WaterSupply getById(Long id) {
        Assert.notNull(id, "WaterSupply id should not be null");
        return waterSupplyRepository.findById(id).orElseThrow(() -> new WaterSupplyNotFoundException(id));
    }

    @Override
    public void save(CreateWaterSupplyRequest createWaterSupplyRequest) {
        Assert.notNull(createWaterSupplyRequest, "WaterSupply dto should not be null");
        waterSupplyRepository.save(waterSupplyMapper.toWaterSupply(createWaterSupplyRequest));
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "WaterSupply id should not be null");
        WaterSupply waterSupply = waterSupplyRepository.findById(id).orElseThrow(() -> new WaterSupplyNotFoundException(id));
        waterSupplyRepository.delete(waterSupply);
    }
}
