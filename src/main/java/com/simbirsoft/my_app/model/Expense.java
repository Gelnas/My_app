package com.simbirsoft.my_app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Calendar;

//траты за месяц по всем категориям

@Entity
@Table(name = "expense")
@Data
@NoArgsConstructor
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

    public void setScoreWater(WaterSupply scoreWater) {
        this.scoreWater = scoreWater;
    }

    public void setScoreElect(Electricity scoreElect) {
        this.scoreElect = scoreElect;
    }
}
