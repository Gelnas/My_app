package com.simbirsoft.my_app.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "electricity")
public class Electricity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Calendar date;

    @Column(name = "counter")
    private Integer counter;

    @Column(name = "score")
    private Double score;

}
