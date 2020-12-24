package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.exception.WaterSupplyNotFoundException;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.repository.WaterSupplyRepository;
import com.simbirsoft.my_app.service.WaterSupplyServiсe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class WaterSupplyServiсeImpl implements WaterSupplyServiсe {


    private final WaterSupplyRepository waterSupplyRepository;

    @Transactional(readOnly = true)
    @Override
    public WaterSupply getById(Long id) {
        Assert.notNull(id, "WaterSupply id should not be null");
        return waterSupplyRepository.findById(id).orElseThrow(() -> new WaterSupplyNotFoundException(id));
    }

    @Override
    public WaterSupply save(WaterSupply waterSupply) {
        Assert.notNull(waterSupply, "WaterSupply dto should not be null");
        return waterSupplyRepository.save(waterSupply);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "WaterSupply id should not be null");
        WaterSupply waterSupply = waterSupplyRepository.findById(id).orElseThrow(() -> new WaterSupplyNotFoundException(id));
        waterSupplyRepository.delete(waterSupply);
    }
}
