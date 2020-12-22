package com.simbirsoft.my_app.dto.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateRateRequest {

    @NotBlank(message = "{\"field\":\"rateWH\", \"message\":\"Это поле обязательно\"}")
    private final Double rateWH;

    @NotBlank(message = "{\"field\":\"rateWC\", \"message\":\"Это поле обязательно\"}")
    private final Double rateWC;

    @NotBlank(message = "{\"field\":\"rateE\", \"message\":\"Это поле обязательно\"}")
    private final Double rateE;
}
