package com.simbirsoft.my_app.dto.request;

import com.simbirsoft.my_app.model.Expense;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

/**
 * Dto for requests about {@link Expense expense} entity
 */

@Data
@Builder
public class CreateExpenseRequest {

    /**
     * Date of data entry
     */
    @NotBlank(message = "{\"field\":\"date\", \"message\":\"Это поле обязательно\"}")
    private final Calendar date;

    /**
     * Water reading data
     */
    @NotBlank(message = "{\"field\":\"waterId\", \"message\":\"Это поле обязательно\"}")
    private final Long waterId;

    /**
     * Electricity reading data
     */
    @NotBlank(message = "{\"field\":\"electId\", \"message\":\"Это поле обязательно\"}")
    private final Long electId;
}
