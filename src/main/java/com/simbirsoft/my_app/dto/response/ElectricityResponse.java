package com.simbirsoft.my_app.dto.response;

import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.WaterSupply;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Calendar;

@Data
@Builder
@RequiredArgsConstructor
public class ElectricityResponse {

    private final Calendar date;
    private final WaterSupply scoreWater;
    private final Electricity scoreElect;
}
