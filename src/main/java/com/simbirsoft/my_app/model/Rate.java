package com.simbirsoft.my_app.model;


import javax.persistence.*;

//тарифы

@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //тарифы на холодную воду
    @Column(name = "ratewh")
    private Double rateWH;

    //тарифы на горячую воду
    @Column(name = "ratewc")
    private Double rateWC;

    //тарифы на электричество
    @Column(name = "rateE")
    private Double rateE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
