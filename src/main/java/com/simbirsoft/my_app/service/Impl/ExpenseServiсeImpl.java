package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.exception.ExpenseNotFoundException;
import com.simbirsoft.my_app.mapper.ExpenseMapper;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.repository.ExpenseRepository;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import com.simbirsoft.my_app.service.ExpenseServiсe;
import com.simbirsoft.my_app.service.WaterSupplyServiсe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class  ExpenseServiсeImpl implements ExpenseServiсe {


    private final ExpenseRepository expenseRepository;

    @Autowired
    private ElectricityServiсe electricityServiсe;

    @Autowired
    private WaterSupplyServiсe waterSupplyServiсe;

    private final ExpenseMapper expenseMapper;

    @Transactional(readOnly = true)
    @Override
    public Expense getById(Long id) {
        Assert.notNull(id, "Expense id should not be null");
        return expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    @Override
    public Expense save(Expense expense) {
        Assert.notNull(expense, "Expense dto should not be null");
        return expenseRepository.save(expense);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Expense id should not be null");
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
        expenseRepository.delete(expense);
    }

}
