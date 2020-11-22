package com.simbirsoft.my_app.service.Impl;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.repository.ExpenseRepository;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import com.simbirsoft.my_app.service.ExpenseServiсe;
import com.simbirsoft.my_app.service.WaterSupplyServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiсeImpl implements ExpenseServiсe {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ElectricityServiсe electricityServiсe;

    @Autowired
    private WaterSupplyServiсe waterSupplyServiсe;

    @Override
    public Expense getById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ExpenseDto expenseDto) {

        Expense expense = new Expense();

        expense.setDate(expenseDto.getDate());
        expense.setScoreElect(electricityServiсe.getById(expenseDto.getElectId()));
        expense.setScoreWater(waterSupplyServiсe.getById(expenseDto.getWaterId()));

        expenseRepository.save(expense);
    }

    @Override
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
}
