package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.mapper.ElectricityMapper;
import com.simbirsoft.my_app.mapper.WaterSupplyMapper;
import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.WaterSupply;
import com.simbirsoft.my_app.repository.ElectricityRepository;
import com.simbirsoft.my_app.repository.WaterSupplyRepository;
import com.simbirsoft.my_app.service.Impl.ElectricityServiсeImpl;
import com.simbirsoft.my_app.service.Impl.WaterSupplyServiсeImpl;
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
public class WaterSupplyServiсeImplTest {
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
    public void testGetObject_GetByID_WaterSupply(){
        Long id = new Long(1);
        Calendar date = new GregorianCalendar();
        WaterSupply waterSupply = new WaterSupply(id, date, 123, 256, 5.0, 2.3) ;
        Optional<WaterSupply> waterSupply1;
        waterSupply1 = Optional.ofNullable(waterSupply);

        WaterSupplyRepository waterSupplyRepository = Mockito.mock(WaterSupplyRepository.class);
        Mockito.when(waterSupplyRepository.findById(id)).thenReturn(waterSupply1);
        WaterSupplyMapper waterSupplyMapper = Mockito.mock(WaterSupplyMapper.class);

        WaterSupplyServiсe waterSupplyServiсe = new WaterSupplyServiсeImpl(waterSupplyRepository, waterSupplyMapper);
        Assertions.assertEquals(waterSupplyServiсe.getById(id), waterSupply1.orElse(null));
    }
}
