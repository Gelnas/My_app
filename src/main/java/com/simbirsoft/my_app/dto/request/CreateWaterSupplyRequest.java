package com.simbirsoft.my_app.dto.request;

import com.simbirsoft.my_app.model.WaterSupply;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Calendar;

/**
 * Dto for requests about {@link WaterSupply waterSupply} entity
 */


@Data
@Builder
public class CreateWaterSupplyRequest {

    /**
     * Date of data entry
     */
    @NotBlank(message = "{\"field\":\"date\", \"message\":\"Это поле обязательно\"}")
    private final Calendar date;

    /**
     * Hot water meter readings
     */
    @NotBlank(message = "{\"field\":\"counterHot\", \"message\":\"Это поле обязательно\"}")
    private final Integer counterHot;

    /**
     * Cold water meter readings
     */
    @NotBlank(message = "{\"field\":\"counterCold\", \"message\":\"Это поле обязательно\"}")
    private final Integer counterCold;

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

}
