package com.simbirsoft.my_app.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Calendar date;

    @Column(name = "score_hot")
    private Double scoreHot;

    @Column(name = "score_cold")
    private Double scoreCold;

    @Column(name = "score_water")
    private Double scoreWater;

    @Column(name = "score_elect")
    private Double scoreElect;

}
