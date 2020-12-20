package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.service.Impl.ElectricityServiсeImpl;
import com.simbirsoft.my_app.service.Impl.WaterSupplyServiсeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class ExpenseMapperDecorator implements ExpenseMapper {

    @Autowired
    @Qualifier("delegate")
    private ExpenseMapper delegate;

    @Autowired
    private ElectricityServiсeImpl electricityServiсe;

    @Autowired
    private WaterSupplyServiсeImpl waterSupplyServiсe;

    @Override
    public Expense toExpense(ExpenseDto expenseDto) {
        Expense expense = delegate.toExpense(expenseDto);
        expense.setScoreElect(electricityServiсe.getById(expenseDto.getElectId()));
        expense.setScoreWater(waterSupplyServiсe.getById(expenseDto.getWaterId()));
        return expense;
    }
}
