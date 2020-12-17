package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import com.simbirsoft.my_app.service.ElectricityServiсe;
import com.simbirsoft.my_app.service.Impl.ElectricityServiсeImpl;
import com.simbirsoft.my_app.service.Impl.WaterSupplyServiсeImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ExpenseMapperDecorator implements ExpenseMapper {

    private final ExpenseMapper expenseMapper;

    @Autowired
    private ElectricityServiсeImpl electricityServiсe;

    @Autowired
    private WaterSupplyServiсeImpl waterSupplyServiсe;

    ExpenseMapperDecorator (ExpenseMapper expenseMapper){
        this.expenseMapper = expenseMapper;
    }

    @Override
    public Expense toExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.toExpense(expenseDto);
        expense.setScoreElect(electricityServiсe.getById(expenseDto.getElectId()));
        expense.setScoreWater(waterSupplyServiсe.getById(expenseDto.getWaterId()));
        return expense;
    }
}
