package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.request.CreateElectricityRequest;
import com.simbirsoft.my_app.dto.response.ElectricityResponse;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
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
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping("/create")
    public ResponseEntity<ElectricityResponse> addElectData(@Valid @RequestBody CreateElectricityRequest createElectricityRequest){
        if(isEmpty(createElectricityRequest)){
            return ResponseEntity.badRequest().build();
        }

        electricityServiсe.save(createElectricityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAuthority('DELETE')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Delete electricity by id")
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
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
