package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.request.CreateExpenseRequest;
import com.simbirsoft.my_app.dto.response.ExpenseResponse;
import com.simbirsoft.my_app.model.Expense;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Controller for working with {@link Expense expense} entity
 */

public interface ExpenseController {

    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Find rate by id")
    @Operation(summary = "Get expense information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<ExpenseResponse> getById(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Expense id",
            example = "1",
            required = true) @PathVariable("id") Long id);


    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Create new expense")
    @Operation(summary = "Get expense information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping
    ResponseEntity<ExpenseResponse> saveElectData(@Valid @RequestBody CreateExpenseRequest createExpenseRequest);


    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Delete expense by id")
    @Operation(summary = "Get expense information" )
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
            value = "Expense id",
            example = "1",
            required = true) @PathVariable Long id);

    }


