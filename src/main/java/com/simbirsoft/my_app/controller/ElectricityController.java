package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.ObjectUtils.isEmpty;


@RestController
@RequestMapping("/api/v1/electricity")
@RequiredArgsConstructor
@Api(tags = "Electricity")
public class ElectricityController {

    @Autowired
    private final ElectricityServiсe electricityServiсe;

    @PreAuthorize("hasAuthority('READ')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Find by id")
    @GetMapping("/{id}")
    public ResponseEntity<Electricity> getById(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Electricity id",
            example = "1",
            required = true)
            @PathVariable("id") Long id){

        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        Electricity electricity = electricityServiсe.getById(id);
        if (isEmpty(electricity)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(electricity);
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Create new electricity")
    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody ElectricityDto electricityDto, RateDto rateDto){
        if(isEmpty(electricityDto)|| isEmpty(rateDto)){
            return ResponseEntity.badRequest().build();
        }

        electricityServiсe.save(electricityDto, rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAuthority('DELETE')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Delete electricity by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Electricity id",
            example = "1",
            required = true)
            @PathVariable Long id){
        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        Electricity electricity = electricityServiсe.getById(id);
         if(isEmpty(electricity)){
             return ResponseEntity.notFound().build();
         }

         electricityServiсe.delete(id);
         return ResponseEntity.ok().build();
    }


}
