package com.simbirsoft.my_app.dto;

import javax.persistence.Column;
import java.util.Calendar;

public class WaterSupplyDto {

    private Calendar date;
    private Integer counterHot;
    private Integer counterCold;


    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getCounterHot() {
        return counterHot;
    }

    public void setCounterHot(Integer counterHot) {
        this.counterHot = counterHot;
    }

    public Integer getCounterCold() {
        return counterCold;
    }

    public void setCounterCold(Integer counterCold) {
        this.counterCold = counterCold;
    }

}
