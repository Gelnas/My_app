package com.simbirsoft.my_app.servise;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricityServiseImpl implements ElectricityServise{

    @Autowired
    private ElectricityRepository electricityRepository;

    @Override
    public Electricity getById(Long id) {
        return electricityRepository.findById(id).orElse(null);
    }

    @Override
        public void save(ElectricityDto electDto) {
        Electricity elect = new Electricity();
        elect.setDate(electDto.getDate());
        elect.setCounter(electDto.getCounter());
        elect.setScore(electDto.getScore());
        electricityRepository.save(elect);

    }

    @Override
    public void delete(Long id) {
        electricityRepository.deleteById(id);

    }
}
