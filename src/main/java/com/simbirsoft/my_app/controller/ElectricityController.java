package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.servise.ElectricityServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/electricity")
public class ElectricityController {

    @Autowired
    private ElectricityServise electricityServise;

    @GetMapping("/{id}")
    public ResponseEntity<Electricity> getById(@PathVariable("id") Long id){

        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Electricity electricity = electricityServise.getById(id);
        if (electricity.equals(null)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(electricity);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody ElectricityDto electricityDto){
        RateDto rateDto = new RateDto();
        if(electricityDto.equals(null)){
            return ResponseEntity.badRequest().build();
        }

        electricityServise.save(electricityDto, rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Electricity electricity = electricityServise.getById(id);
         if(electricity.equals(null)){
             return ResponseEntity.notFound().build();
         }

         electricityServise.delete(id);
         return ResponseEntity.ok().build();
    }


}
