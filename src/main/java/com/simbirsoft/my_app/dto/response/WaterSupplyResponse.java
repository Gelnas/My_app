package com.simbirsoft.my_app.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@Data
@Builder
@RequiredArgsConstructor
public class WaterSupplyResponse {

    private final Calendar date;
    private final Integer counterHot;
    private final Integer counterCold;
    private final Double scoreHot;
    private final Double scoreCold;
}
