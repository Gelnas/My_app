package com.simbirsoft.my_app.model;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Calendar;

// Показатели электросчётчика

@Entity
@Table(name = "electricity")
@Data
@Builder
public class Electricity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dateN")
    private Calendar date;

    //Показания счётчика
    @Column(name = "counter")
    private Integer counter;

    //Сумма за месяц
    @Column(name = "score")
    private Double score;
}
