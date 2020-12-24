package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.request.CreateRateRequest;
import com.simbirsoft.my_app.dto.response.RateResponse;
import com.simbirsoft.my_app.model.Rate;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Controller for working with {@link Rate rate} entity
 */

public interface RateController {

    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "find rate by id")
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping(value = "/{id}")
    ResponseEntity<RateResponse> getById(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Rate id",
            example = "1",
            required = true) @PathVariable("id") Long id);




    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Create new rate")
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping
    ResponseEntity<RateResponse> saveElectData(@ApiParam(
            name =  "id",
            value = "RateDto",
            required = true) @Valid @RequestBody CreateRateRequest createRateRequest);




    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Delete old rate")
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> delete(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Rate id",
            example = "1",
            required = true) @PathVariable Long id);
}
