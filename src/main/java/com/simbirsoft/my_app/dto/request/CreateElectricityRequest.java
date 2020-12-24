package com.simbirsoft.my_app.dto.request;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@Builder
public class CreateElectricityRequest {

    @NotBlank(message = "{\"field\":\"date\", \"message\":\"Это поле обязательно\"}")
    private final Calendar date;

    @NotBlank(message = "{\"field\":\"name\", \"message\":\"Это поле обязательно\"}")
    @Size(max = 6, message = "{\"field\":\"name\", \"message\":\"Размер данного поля не должен превышать 6 символов\"}")
    private final Integer counter;

    @NotBlank(message = "{\"field\":\"rateE\", \"message\":\"Это поле обязательно\"}")
    private Double rateE;
}
