package com.simbirsoft.my_app.dto;

import lombok.Builder;

public class RateDto {

    //тариф горячей воды
    private Double rateWH;
    //тариф холодной воды
    private Double rateWC;
    //тариф электричества
    private Double rateE;

    public Double getRateWH() {
        return rateWH;
    }

    public void setRateWH(Double rateWH) {
        this.rateWH = rateWH;
    }

    public Double getRateWC() {
        return rateWC;
    }

    public void setRateWC(Double rateWC) {
        this.rateWC = rateWC;
    }

    public Double getRateE() {
        return rateE;
    }

    public void setRateE(Double rateE) {
        this.rateE = rateE;
    }


}
