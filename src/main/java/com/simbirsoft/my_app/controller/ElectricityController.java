package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.request.CreateElectricityRequest;
import com.simbirsoft.my_app.dto.response.ElectricityResponse;
import com.simbirsoft.my_app.model.Electricity;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Controller for working with {@link Electricity electricity} entity
 */

public interface ElectricityController {

    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Find by id")
    @Operation(summary = "Get electricity information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<ElectricityResponse> getById(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Electricity id",
            example = "1",
            required = true) @PathVariable("id") Long id);


    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Create new electricity")
    @Operation(summary = "Get electricity information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping
    ResponseEntity<ElectricityResponse> saveElectData(@Valid @RequestBody CreateElectricityRequest createElectricityRequest);


    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Delete electricity by id")
    @Operation(summary = "Get electricity information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @DeleteMapping("/{id}")
     ResponseEntity<String> delete(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Electricity id",
            example = "1",
            required = true) @PathVariable Long id);

    }


