package com.simbirsoft.my_app.dto.request;


import com.simbirsoft.my_app.model.Rate;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * Dto for requests about {@link Rate rate} entity
 */
@Data
@Builder
public class CreateRateRequest {

    /**
     * Hot water tariffs
     */
    @NotBlank(message = "{\"field\":\"rateWH\", \"message\":\"Это поле обязательно\"}")
    private final Double rateWH;

    /**
     * Cold water tariffs
     */
    @NotBlank(message = "{\"field\":\"rateWC\", \"message\":\"Это поле обязательно\"}")
    private final Double rateWC;

    /**
     * Electricity tariffs
     */
    @NotBlank(message = "{\"field\":\"rateE\", \"message\":\"Это поле обязательно\"}")
    private final Double rateE;
}
