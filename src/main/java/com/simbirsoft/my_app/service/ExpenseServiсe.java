package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Expense;

public interface ExpenseServiсe {
    Expense getById(Long id);
    void save(ExpenseDto expenseDto);
    void delete(Long id);
}
