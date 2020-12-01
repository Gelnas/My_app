package com.simbirsoft.my_app.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
//Показания счётчика водоснабжения
@Entity
@Table(name = "water_supply")
@Data
@RequiredArgsConstructor
public class WaterSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Calendar date;

    //Показания ГВС
    @Column(name = "counterHot")
    private Integer counterHot;

    //Показания ХВС
    @Column(name = "counterCold")
    private Integer counterCold;

    //Чек за ГВС
    @Column(name = "scoreHot")
    private Double scoreHot;

    //Чек за ХВС
    @Column(name = "scoreCold")
    private Double scoreCold;
}
