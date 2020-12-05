package com.simbirsoft.my_app.model;


import lombok.*;

import javax.persistence.*;

//тарифы

@Entity
@Table(name = "rate")
@Data
@NoArgsConstructor
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
}
