package com.simbirsoft.my_app.servise.Impl;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.repository.ExpenseRepository;
import com.simbirsoft.my_app.servise.ElectricityServise;
import com.simbirsoft.my_app.servise.ExpenseServise;
import com.simbirsoft.my_app.servise.WaterSupplyServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiseImpl implements ExpenseServise {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ElectricityServise electricityServise;

    @Autowired
    private WaterSupplyServise waterSupplyServise;

    @Override
    public Expense getById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ExpenseDto expenseDto) {

        Expense expense = new Expense();

        expense.setDate(expenseDto.getDate());
        expense.setScoreElect(electricityServise.getById(expenseDto.getElectId()));
        expense.setScoreWater(waterSupplyServise.getById(expenseDto.getWaterId()));

        expenseRepository.save(expense);
    }

    @Override
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
}
