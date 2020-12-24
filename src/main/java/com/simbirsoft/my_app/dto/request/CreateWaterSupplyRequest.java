package com.simbirsoft.my_app.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@Data
@Builder
public class CreateWaterSupplyRequest {

    @NotBlank(message = "{\"field\":\"date\", \"message\":\"Это поле обязательно\"}")
    private final Calendar date;

    @NotBlank(message = "{\"field\":\"counterHot\", \"message\":\"Это поле обязательно\"}")
    private final Integer counterHot;

    @NotBlank(message = "{\"field\":\"counterCold\", \"message\":\"Это поле обязательно\"}")
    private final Integer counterCold;

    @NotBlank(message = "{\"field\":\"rateWH\", \"message\":\"Это поле обязательно\"}")
    private final Double rateWH;

    @NotBlank(message = "{\"field\":\"rateWC\", \"message\":\"Это поле обязательно\"}")
    private final Double rateWC;

}
