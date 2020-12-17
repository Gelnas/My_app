package com.simbirsoft.my_app.dto;


import lombok.Data;

import java.util.Calendar;

@Data
public class WaterSupplyDto {

    private Calendar date;
    private Integer counterHot;
    private Integer counterCold;
}
