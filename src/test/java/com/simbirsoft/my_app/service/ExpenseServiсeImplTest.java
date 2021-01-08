package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.mapper.ExpenseMapper;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.Expense;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.repository.ExpenseRepository;
import com.simbirsoft.my_app.service.Impl.ExpenseServiсeImpl;
import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ExpenseServiсeImplTest {
    private static Validator validator;
    private static ValidatorFactory validatorFactory;
    private static AutoCloseable openedMocks;

    @BeforeAll
    public static void init(){
        validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        //openedMocks = MockitoAnnotations.openMocks(RateServiсeImplTest.class);
    }

    @Test
    public void testGetObject_GetByID_Expense(){
        Long id = new Long(1);
        Calendar date = new GregorianCalendar();
        WaterSupply waterSupply = new WaterSupply(id, date, 123, 256, 5.0, 2.3);
        Electricity electricity = new Electricity(id, date, 123, 5.0);
        Expense expense = new Expense(id, date, waterSupply, electricity) ;
        Optional<Expense> expense1;
        expense1 = Optional.ofNullable(expense);

        ExpenseRepository expenseRepository = Mockito.mock(ExpenseRepository.class);
        Mockito.when(expenseRepository.findById(id)).thenReturn(expense1);
        ExpenseMapper expenseMapper = Mockito.mock(ExpenseMapper.class);

        ExpenseServiсe expenseServiсe = new ExpenseServiсeImpl(expenseRepository, expenseMapper);
        Assertions.assertEquals(expenseServiсe.getById(id), expense1.orElse(null));
    }

}
