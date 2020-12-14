package com.simbirsoft.my_app.model;


import lombok.*;

import javax.persistence.*;

//тарифы

@Entity
@Table(name = "rate")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //тарифы на холодную воду
    @Column(name = "rate_wh")
    private Double rateWH;

    //тарифы на горячую воду
    @Column(name = "rate_wc")
    private Double rateWC;

    //тарифы на электричество
    @Column(name = "rate_E")
    private Double rateE;

    public Rate() {

    }

    public Rate(Long id, Double rateWH, Double rateWC, Double rateE) {
        this.id = id;
        this.rateWH = rateWH;
        this.rateWC = rateWC;
        this.rateE = rateE;
    }
}
