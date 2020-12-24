package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.Urls;
import com.simbirsoft.my_app.dto.request.CreateElectricityRequest;
import com.simbirsoft.my_app.dto.response.ElectricityResponse;
import com.simbirsoft.my_app.mapper.ElectricityMapper;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.util.ObjectUtils.isEmpty;


@RestController
@RequestMapping(Urls.Electricity.FULL)
@RequiredArgsConstructor
@Api(tags = "Electricity")
public class ElectricityControllerImpl implements ElectricityController {

   private final ElectricityServiсe electricityServiсe;
   private final ElectricityMapper electricityMapper;

   @PreAuthorize("hasAuthority('READ')")
   @Override
    public ResponseEntity<ElectricityResponse> getById(Long id){

        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(electricityMapper
                .toElectricityResponse(electricityServiсe.getById(id)));
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @Override
    public ResponseEntity<ElectricityResponse> saveElectData(@Valid @RequestBody CreateElectricityRequest createElectricityRequest){
        if(isEmpty(createElectricityRequest)){
            return ResponseEntity.badRequest().build();
        }
       return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(electricityMapper.toElectricityResponse(
                        electricityServiсe.save(
                                electricityMapper.toElectricity(createElectricityRequest))));
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @Override
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
