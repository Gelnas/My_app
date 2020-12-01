package com.simbirsoft.my_app.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

//траты за месяц по всем категориям

@Entity
@Table(name = "expense")
@Data
@RequiredArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //месяц
    @Column(name = "date")
    private Calendar date;

    //траты за воду в течении месяца
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "water_Id", referencedColumnName = "id")
    private WaterSupply scoreWater;

    //траты за электричество в течении месяца
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "elect_Id", referencedColumnName = "id")
    private Electricity scoreElect;
}
