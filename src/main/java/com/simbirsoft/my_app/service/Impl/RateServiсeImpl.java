package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.exception.RateNotFoundException;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.repository.RateRepository;
import com.simbirsoft.my_app.service.RateServiсe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class RateServiсeImpl implements RateServiсe {

    private final RateRepository rateRepository;

    @Transactional(readOnly = true)
    @Override
    public Rate getById(Long id) {
        Assert.notNull(id, "Rate id should not be null");
        return rateRepository.findById(id).orElseThrow(() -> new RateNotFoundException(id));
    }

    @Override
    public Rate save(Rate rate) {
        Assert.notNull(rate, "Rate dto should not be null");
        return rateRepository.save(rate);
 }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Rate id should not be null");
        Rate rate = rateRepository.findById(id).orElseThrow(() -> new RateNotFoundException(id));
        rateRepository.delete(rate);
    }
}
