package com.simbirsoft.my_app.servise;

import com.simbirsoft.my_app.dto.ElectricityDto;
import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.Expense;

public interface ExpenseServise {
    Expense getById(Long id);
    void save(ExpenseDto expenseDto);
    void delete(Long id);
}
