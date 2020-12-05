package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.service.ExpenseServiсe;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/expense")
@AllArgsConstructor
@Api(tags = "Expense")
public class ExpenseController {

    @Autowired
    private final ExpenseServiсe expenseService;

    @PreAuthorize("hasAuthority('READ')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Find rate by id")
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getById(@ApiParam(
            name =  "id",
            type = "Integer",
            value = "Expense id",
            example = "1",
            required = true)
            @PathVariable("id") Long id){

        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        Expense expense = expenseService.getById(id);
        if (isEmpty(expense)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(expense);
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Create new expense")
    @Operation(summary = "Get rate information" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", responseContainer = "List"),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 401, message = "Unauthorized. To perform this operation, you need to log in"),
            @ApiResponse(code = 403, message = "Forbidden. You don't have access to this data"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody ExpenseDto expenseDto){
        if(isEmpty(expenseDto)){
            return ResponseEntity.badRequest().build();
        }

        expenseService.save(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAuthority('DELETE')")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "Delete expense by id")
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
            value = "Expense id",
            example = "1",
            required = true)
            @PathVariable Long id){
        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }

        Expense expense = expenseService.getById(id);
        if(isEmpty(expense)){
            return ResponseEntity.notFound().build();
        }

        expenseService.delete(id);
        return ResponseEntity.ok().build();
    }


}
