package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.service.RateServiсe;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static org.springframework.util.ObjectUtils.isEmpty;


@RestController
@Api(tags = "Rate")
@RequestMapping("/api/v1/rate")
@AllArgsConstructor
public class RateController {

    @Autowired
    private final RateServiсe rateServiсe;

    @PreAuthorize("hasAuthority('READ')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "find rate by id")

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Rate> getById( @ApiParam(
            name =  "id",
            type = "Integer",
            value = "Rate id",
            example = "1",
            required = true)
            @PathVariable("id") Long id) {
        ResponseEntity<Rate> result;
        if (isEmpty(id)) {
            result = ResponseEntity.badRequest().build();
        } else {
            Rate rate = rateServiсe.getById(id);
            if (isEmpty(rate)) {
                result = ResponseEntity.noContent().build();
            } else {
                result = ResponseEntity.ok(rate);
            }
        }

        return result;
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping("/create")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Create new rate")
    public ResponseEntity<String> addElectData(@ApiParam(
            name =  "id",
            value = "RateDto",
            required = true)
            @RequestBody RateDto rateDto){

        if(isEmpty(rateDto)){
            return ResponseEntity.badRequest().build();
        }

        rateServiсe.save(rateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Delete old rate")
    public ResponseEntity<String> delete(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Rate id",
            example = "1",
            required = true)
            @PathVariable Long id){
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
