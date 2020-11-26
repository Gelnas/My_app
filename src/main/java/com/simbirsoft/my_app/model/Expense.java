package com.simbirsoft.my_app.model;

import javax.persistence.*;
import java.util.Calendar;

//траты за месяц по всем категориям

@Entity
@Table(name = "expense")
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

   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public WaterSupply getScoreWater() {
        return scoreWater;
    }

    public void setScoreWater(WaterSupply scoreWater) {
        this.scoreWater = scoreWater;
    }

    public Electricity getScoreElect() {
        return scoreElect;
    }

    public void setScoreElect(Electricity scoreElect) {
        this.scoreElect = scoreElect;
    }



}
