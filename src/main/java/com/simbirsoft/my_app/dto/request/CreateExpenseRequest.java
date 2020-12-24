package com.simbirsoft.my_app.dto.request;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@Data
@Builder
public class CreateExpenseRequest {

    @NotBlank(message = "{\"field\":\"date\", \"message\":\"Это поле обязательно\"}")
    private final Calendar date;

    @NotBlank(message = "{\"field\":\"waterId\", \"message\":\"Это поле обязательно\"}")
    private final Long waterId;

    @NotBlank(message = "{\"field\":\"electId\", \"message\":\"Это поле обязательно\"}")
    private final Long electId;
}
