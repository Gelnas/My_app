package com.simbirsoft.my_app.dto;

import com.simbirsoft.my_app.model.Electricity;
import com.simbirsoft.my_app.model.WaterSupply;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Calendar;

public class ExpenseDto {

    private Calendar date;
    private Long waterId;
    private Long electId;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Long getWaterId() {
        return waterId;
    }

    public void setWaterId(Long waterId) {
        this.waterId = waterId;
    }

    public Long getElectId() {
        return electId;
    }

    public void setElectId(Long electId) {
        this.electId = electId;
    }
}
