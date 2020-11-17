package com.simbirsoft.my_app.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "water_supply")
public class WaterSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Calendar date;

    @Column(name = "counter_hot")
    private Integer counterHot;

    @Column(name = "counter_cold")
    private Integer counterCold;

    @Column(name = "score_hot")
    private Double scoreHot;

    @Column(name = "score_cold")
    private Double scoreCold;
}
