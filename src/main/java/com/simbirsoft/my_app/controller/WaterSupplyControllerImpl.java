package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.Urls;
import com.simbirsoft.my_app.dto.request.CreateWaterSupplyRequest;
import com.simbirsoft.my_app.dto.response.WaterSupplyResponse;
import com.simbirsoft.my_app.mapper.WaterSupplyMapper;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.service.WaterSupplyServiсe;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.util.ObjectUtils.isEmpty;


@RestController
@RequestMapping(Urls.WaterSupply.FULL)
@RequiredArgsConstructor
@Api(tags = "WaterSupply")
public class WaterSupplyControllerImpl implements WaterSupplyController{

    private final WaterSupplyServiсe waterSupplyServiсe;
    private final WaterSupplyMapper waterSupplyMapper;

    @Override
    public ResponseEntity<WaterSupplyResponse> getById(@PathVariable("id") Long id){

        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(waterSupplyMapper.toWaterSupplyResponse(waterSupplyServiсe.getById(id)));
    }

    @Override
    public ResponseEntity<WaterSupplyResponse> saveElectData(@Valid @RequestBody CreateWaterSupplyRequest createWaterSupplyRequest){

        if(isEmpty(createWaterSupplyRequest)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(waterSupplyMapper.toWaterSupplyResponse(
                        waterSupplyServiсe.save(
                                waterSupplyMapper.toWaterSupply(createWaterSupplyRequest))));
    }

    @Override
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
