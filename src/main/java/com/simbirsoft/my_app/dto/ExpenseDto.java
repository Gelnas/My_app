package com.simbirsoft.my_app.dto;

import lombok.Data;
import java.util.Calendar;

@Data
public class ExpenseDto {

    private Calendar date;
    private Long waterId;
    private Long electId;

}
