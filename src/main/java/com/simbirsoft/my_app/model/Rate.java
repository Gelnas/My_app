package com.simbirsoft.my_app.model;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rate_wh")
    private Integer rateWH;

    @Column(name = "rate_wc")
    private Integer rateWC;

    @Column(name = "rate_E")
    private Double rateE;

}
