package com.simbirsoft.my_app.servise.Impl;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import com.simbirsoft.my_app.repository.RateRepository;
import com.simbirsoft.my_app.servise.RateServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiseImpl implements RateServise {

    @Autowired
    private RateRepository rateRepository;


    @Override
    public Rate getById(Long id) {
        return rateRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RateDto rateDto) {
        Rate rate = new Rate();

        rate.setRateE(rateDto.getRateE());
        rate.setRateWC(rateDto.getRateWC());
        rate.setRateWH(rateDto.getRateWH());

        rateRepository.save(rate);

    }

    @Override
    public void delete(Long id) {
        rateRepository.deleteById(id);
    }
}
