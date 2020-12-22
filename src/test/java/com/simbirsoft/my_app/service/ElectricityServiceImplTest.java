package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.mapper.ElectricityMapper;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import com.simbirsoft.my_app.service.Impl.ElectricityServiсeImpl;
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
public class ElectricityServiceImplTest {
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
    public void testGetObject_GetByID_Electricity(){
        Long id = new Long(1);
        Calendar date = new GregorianCalendar();
        Electricity electricity = new Electricity(id, date, 123, 5.0);
        Optional<Electricity> electricity1;
        electricity1 = Optional.ofNullable(electricity);

        ElectricityRepository electricityRepository = Mockito.mock(ElectricityRepository.class);
        Mockito.when(electricityRepository.findById(id)).thenReturn(electricity1);
        ElectricityMapper electricityMapper = Mockito.mock(ElectricityMapper.class);

        ElectricityServiсe electricityServiсe = new ElectricityServiсeImpl(electricityRepository, electricityMapper);
        Assertions.assertEquals(electricityServiсe.getById(id), electricity1.orElse(null));
    }
}
