package com.simbirsoft.my_app.mapper;

import com.simbirsoft.my_app.dto.ExpenseDto;
import com.simbirsoft.my_app.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.Table;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)

            //@Mapping(target = "scoreWater", source = "waterId"),
           // @Mapping(target = "scoreElect", source = "electId")
    })
    Expense toExpense(ExpenseDto expenseDto);
}
