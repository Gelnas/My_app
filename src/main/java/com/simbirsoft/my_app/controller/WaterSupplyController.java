package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.service.WaterSupplyServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/waterSupply")
public class WaterSupplyController {

    @Autowired
    private WaterSupplyServiсe waterSupplyServiсe;

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public ResponseEntity<WaterSupply> getById(@PathVariable("id") Long id){

        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        WaterSupply waterSupply = waterSupplyServiсe.getById(id);
        if (isEmpty(waterSupply)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(waterSupply);
    }

    @PreAuthorize("hasAuthority('WRTIE')")
    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody WaterSupplyDto waterSupplyDto, RateDto rateDto){

        if(isEmpty(waterSupplyDto) || isEmpty(rateDto)){
            return ResponseEntity.badRequest().build();
        }

        waterSupplyServiсe.save(waterSupplyDto, rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        WaterSupply waterSupply = waterSupplyServiсe.getById(id);
        if(isEmpty(waterSupply)){
            return ResponseEntity.notFound().build();
        }

        waterSupplyServiсe.delete(id);
        return ResponseEntity.ok().build();
    }


}
