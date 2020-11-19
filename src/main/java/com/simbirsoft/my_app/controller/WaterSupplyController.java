package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.servise.WaterSupplyServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/waterSupply")
public class WaterSupplyController {

    @Autowired
    private WaterSupplyServise waterSupplyServise;

    @GetMapping("/{id}")
    public ResponseEntity<WaterSupply> getById(@PathVariable("id") Long id){

        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        WaterSupply waterSupply = waterSupplyServise.getById(id);
        if (waterSupply.equals(null)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(waterSupply);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody WaterSupplyDto waterSupplyDto){
        RateDto rateDto = new RateDto();
        if(waterSupplyDto.equals(null)){
            return ResponseEntity.badRequest().build();
        }

        waterSupplyServise.save(waterSupplyDto, rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        WaterSupply waterSupply = waterSupplyServise.getById(id);
        if(waterSupply.equals(null)){
            return ResponseEntity.notFound().build();
        }

        waterSupplyServise.delete(id);
        return ResponseEntity.ok().build();
    }


}
