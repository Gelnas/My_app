package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.request.CreateRateRequest;
import com.simbirsoft.my_app.exception.RateNotFoundException;
import com.simbirsoft.my_app.mapper.RateMapper;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.repository.RateRepository;
import com.simbirsoft.my_app.service.RateServiсe;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class RateServiсeImpl implements RateServiсe {

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private RateMapper rateMapper;

    @Transactional(readOnly = true)
    @Override
    public Rate getById(Long id) {
        Assert.notNull(id, "Rate id should not be null");
        return rateRepository.findById(id).orElseThrow(() -> new RateNotFoundException(id));
    }

    @Override
    public void save(CreateRateRequest createRateRequest) {
        Assert.notNull(createRateRequest, "Rate dto should not be null");
        rateRepository.save(rateMapper.toRate(createRateRequest));
 }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Rate id should not be null");
        Rate rate = rateRepository.findById(id).orElseThrow(() -> new RateNotFoundException(id));
        rateRepository.delete(rate);
    }
}
