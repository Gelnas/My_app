package com.simbirsoft.my_app.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Calendar;

@Data
@Builder
public class ExpenseResponse {

    private final Calendar date;
    private final Long waterId;
    private final Long electId;
}
