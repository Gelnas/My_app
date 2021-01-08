package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.Urls;
import com.simbirsoft.my_app.dto.request.CreateRateRequest;
import com.simbirsoft.my_app.dto.response.RateResponse;
import com.simbirsoft.my_app.mapper.RateMapper;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.service.RateServiсe;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.util.ObjectUtils.isEmpty;


@RestController
@Api(tags = "Rate")
@RequestMapping(Urls.Rate.FULL)
@RequiredArgsConstructor
public class RateControllerImpl implements RateController{

    private final RateServiсe rateServiсe;
    private final RateMapper rateMapper;

    @Override
    public ResponseEntity<RateResponse> getById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(rateMapper.toRateResponse(rateServiсe.getById(id)));
    }

    @Override
    public ResponseEntity<RateResponse> saveElectData(@Valid @RequestBody CreateRateRequest createRateRequest){

        if(isEmpty(createRateRequest)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(rateMapper.toRateResponse(
                        rateServiсe.save(rateMapper.toRate(createRateRequest))));
    }

    @Override
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
