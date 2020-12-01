package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.service.ExpenseServiсe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "find rate by id")
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getById(@PathVariable("id") Long id){

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
    @ApiOperation(value = "create new expense")
    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody ExpenseDto expenseDto){
        if(isEmpty(expenseDto)){
            return ResponseEntity.badRequest().build();
        }

        expenseService.save(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAuthority('DELETE')")
    @ApiOperation(value = "delete expense by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
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
