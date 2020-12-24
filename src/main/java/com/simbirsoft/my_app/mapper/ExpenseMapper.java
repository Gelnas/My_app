package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.request.CreateExpenseRequest;
import com.simbirsoft.my_app.dto.response.ExpenseResponse;
import com.simbirsoft.my_app.model.Expense;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
@DecoratedWith(ExpenseMapperDecorator.class)
public interface ExpenseMapper  {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    @Mapping(target = "id", ignore = true)
    Expense toExpense(CreateExpenseRequest createExpenseRequest);

    ExpenseResponse toExpenseResponse(Expense expense);
}
