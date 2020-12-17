package com.simbirsoft.my_app.dto;

import lombok.Data;

@Data
public class RateDto {

    //тариф горячей воды
    private Double rateWH;
    //тариф холодной воды
    private Double rateWC;
    //тариф электричества
    private Double rateE;
}
