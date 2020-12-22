package com.simbirsoft.my_app.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RateResponse {

    private final Double rateWH;
    private final Double rateWC;
    private final Double rateE;
}
