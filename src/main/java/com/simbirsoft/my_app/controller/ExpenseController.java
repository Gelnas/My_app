package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.dto.RateDto;
import com.simbirsoft.my_app.dto.WaterSupplyDto;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.servise.ExpenseServise;
import com.simbirsoft.my_app.servise.WaterSupplyServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    @Autowired
    private ExpenseServise expenseServise;

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getById(@PathVariable("id") Long id){

        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Expense expense = expenseServise.getById(id);
        if (expense.equals(null)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(expense);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addElectData(@RequestBody ExpenseDto expenseDto){
        if(expenseDto.equals(null)){
            return ResponseEntity.badRequest().build();
        }

        expenseServise.save(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }

        Expense expense = expenseServise.getById(id);
        if(expense.equals(null)){
            return ResponseEntity.notFound().build();
        }

        expenseServise.delete(id);
        return ResponseEntity.ok().build();
    }


}
