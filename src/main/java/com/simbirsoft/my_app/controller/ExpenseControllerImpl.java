package com.simbirsoft.my_app.controller;

import com.simbirsoft.my_app.Urls;
import com.simbirsoft.my_app.dto.request.CreateExpenseRequest;
import com.simbirsoft.my_app.dto.response.ExpenseResponse;
import com.simbirsoft.my_app.mapper.ExpenseMapper;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.service.ExpenseServiсe;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping(Urls.Expense.FULL)
@RequiredArgsConstructor
@Api(tags = "Expense")
public class ExpenseControllerImpl implements ExpenseController {

    private final ExpenseServiсe expenseService;
    private final ExpenseMapper expenseMapper;

    @Override
    public ResponseEntity<ExpenseResponse> getById(@Valid @PathVariable("id") Long id){

        if(isEmpty(id)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(expenseMapper.toExpenseResponse(expenseService.getById(id)));
    }

    @Override
    public ResponseEntity<ExpenseResponse> saveElectData(@Valid @RequestBody CreateExpenseRequest createExpenseRequest){
        if(isEmpty(createExpenseRequest)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(expenseMapper.toExpenseResponse(
                        expenseService.save(
                                expenseMapper.toExpense(createExpenseRequest))));
    }

    @Override
    public ResponseEntity<String> delete(@Valid @PathVariable("id") Long id){
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
