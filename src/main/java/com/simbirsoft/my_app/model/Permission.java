package com.simbirsoft.my_app.model;

import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "permission")
@Data
@RequiredArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "permission")
    private String permission;
}
