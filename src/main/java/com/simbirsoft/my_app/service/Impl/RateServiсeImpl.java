package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.mapper.RateMapper;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.repository.RateRepository;
import com.simbirsoft.my_app.service.RateServiсe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiсeImpl implements RateServiсe {

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private RateMapper rateMapper;

    public RateServiсeImpl(RateRepository rateRepository, RateMapper rateMapper) {
        this.rateRepository = rateRepository;
        this.rateMapper = rateMapper;
    }

    @Override
    public Rate getById(Long id) {
        return rateRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RateDto rateDto) {
        rateRepository.save(rateMapper.toRate(rateDto));
 }

    @Override
    public void delete(Long id) {
        rateRepository.deleteById(id);
    }
}
