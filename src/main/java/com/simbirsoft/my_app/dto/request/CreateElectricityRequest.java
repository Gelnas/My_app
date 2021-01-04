package com.simbirsoft.my_app.dto.request;

import com.simbirsoft.my_app.model.Electricity;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Calendar;

/**
 * Dto for requests about {@link Electricity electricity} entity
 */

@Data
@Builder
public class CreateElectricityRequest {

    /**
     * Date of data entry
     */
    @NotBlank(message = "{\"field\":\"date\", \"message\":\"Это поле обязательно\"}")
    private final Calendar date;

    /**
     * Electricity meter readings
     */
    @NotBlank(message = "{\"field\":\"name\", \"message\":\"Это поле обязательно\"}")
    @Size(max = 6, message = "{\"field\":\"name\", \"message\":\"Размер данного поля не должен превышать 6 символов\"}")
    private final Integer counter;

    /**
     * Electricity tariffs
     */
    @NotBlank(message = "{\"field\":\"rateE\", \"message\":\"Это поле обязательно\"}")
    private final Double rateE;
}
