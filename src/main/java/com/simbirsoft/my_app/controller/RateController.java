package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.service.RateServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rate")
public class RateController {

    @Autowired
    private RateServiсe rateServiсe;

    @GetMapping("/{id}")
    public ResponseEntity<Rate> getById(@PathVariable("id") Long id){

        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Rate rate = rateServiсe.getById(id);
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

        rateServiсe.save(rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Rate rate = rateServiсe.getById(id);
        if(rate.equals(null)){
            return ResponseEntity.notFound().build();
        }

        rateServiсe.delete(id);
        return ResponseEntity.ok().build();
    }
}
