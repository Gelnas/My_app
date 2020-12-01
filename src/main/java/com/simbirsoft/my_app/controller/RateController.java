package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.service.RateServiсe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static org.springframework.util.ObjectUtils.isEmpty;


@RestController
@RequestMapping("/api/v1/rate")
@AllArgsConstructor
@Api(tags = "Rate")
public class RateController {

    @Autowired
    private final RateServiсe rateServiсe;

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    @ApiOperation(value = "find rate by id")
    public ResponseEntity<Rate> getById(@PathVariable("id") Long id){
            if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        Rate rate = rateServiсe.getById(id);
        if (isEmpty(rate)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rate);
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping("/create")
    @ApiOperation(value = "create new rate")
    public ResponseEntity<String> addElectData(@RequestBody RateDto rateDto){

        if(isEmpty(rateDto)){
            return ResponseEntity.badRequest().build();
        }

        rateServiсe.save(rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete old rate")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        Rate rate = rateServiсe.getById(id);
        if(isEmpty(rate)){
            return ResponseEntity.notFound().build();
        }

        rateServiсe.delete(id);
        return ResponseEntity.ok().build();
    }
}
