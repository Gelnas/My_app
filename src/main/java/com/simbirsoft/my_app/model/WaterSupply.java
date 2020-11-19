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

    public Integer getCounterHot() {
        return counterHot;
    }

    public void setCounterHot(Integer counterHot) {
        this.counterHot = counterHot;
    }

    public Integer getCounterCold() {
        return counterCold;
    }

    public void setCounterCold(Integer counterCold) {
        this.counterCold = counterCold;
    }

    public Double getScoreHot() {
        return scoreHot;
    }

    public void setScoreHot(Double scoreHot) {
        this.scoreHot = scoreHot;
    }

    public Double getScoreCold() {
        return scoreCold;
    }

    public void setScoreCold(Double scoreCold) {
        this.scoreCold = scoreCold;
    }
}
