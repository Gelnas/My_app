package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.servise.RateServise;
import com.simbirsoft.my_app.servise.WaterSupplyServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rate")
public class RateController {

    @Autowired
    private RateServise rateServise;

    @GetMapping("/{id}")
    public ResponseEntity<Rate> getById(@PathVariable("id") Long id){

        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Rate rate = rateServise.getById(id);
        if (rate.equals(null)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rate);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody RateDto rateDto){

        if(rateDto.equals(null)){
            return ResponseEntity.badRequest().build();
        }

        rateServise.save(rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Rate rate = rateServise.getById(id);
        if(rate.equals(null)){
            return ResponseEntity.notFound().build();
        }

        rateServise.delete(id);
        return ResponseEntity.ok().build();
    }
}
