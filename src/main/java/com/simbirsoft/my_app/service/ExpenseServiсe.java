package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.dto.request.CreateExpenseRequest;
import com.simbirsoft.my_app.model.Expense;

public interface ExpenseServiсe {
    Expense getById(Long id);
    void save(CreateExpenseRequest createExpenseRequest);
    void delete(Long id);
}
