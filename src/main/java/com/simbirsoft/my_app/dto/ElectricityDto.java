package com.simbirsoft.my_app.dto;

import lombok.Data;

import java.util.Calendar;

@Data
public class ElectricityDto {

    private Calendar date;
    private Integer counter;
}
