package com.simbirsoft.my_app.service;

import com.simbirsoft.my_app.mapper.RateMapper;
import com.simbirsoft.my_app.model.Rate;
import com.simbirsoft.my_app.repository.RateRepository;
import com.simbirsoft.my_app.service.Impl.RateServiсeImpl;
import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class RateServiсeImplTest {
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
    public void testGetObject_GetByID_Rate(){
        Long id = new Long(1);
        Rate rate1 = new Rate(id, 5.0, 6.8, 7.6);
        Optional<Rate> rate;
        rate = Optional.ofNullable(rate1);

        RateRepository rateRepository = Mockito.mock(RateRepository.class);
        Mockito.when(rateRepository.findById(id)).thenReturn(rate);
        RateMapper rateMapper = Mockito.mock(RateMapper.class);

        RateServiсe rateServiсe = new RateServiсeImpl(rateRepository, rateMapper);
        Assertions.assertEquals(rateServiсe.getById(id), rate.orElse(null));
    }
}
