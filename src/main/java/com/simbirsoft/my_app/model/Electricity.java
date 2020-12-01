package com.simbirsoft.my_app.model;

import com.sun.istack.NotNull;
import jdk.jfr.DataAmount;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Calendar;

// Показатели электросчётчика

@Entity
@Table(name = "electricity")
@Data
@NoArgsConstructor
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
