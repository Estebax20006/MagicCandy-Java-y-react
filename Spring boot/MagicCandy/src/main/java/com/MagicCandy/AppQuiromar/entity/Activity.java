package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "title", length = 30, nullable = false) //Campo base de datos
    private String title; //Nombre de la variable

    @Column(name = "description")
    private String description;

    @Column(name = "start_date", columnDefinition = "DATE")
    private Date startDate; //Fecha inicio actividad

    @Column(name = "end_date", columnDefinition = "DATE")
    private Date endDate; //Fecha fin de la actividad.

    @ManyToOne(targetEntity = Production.class)
    @JoinColumn(name = "fk_production_id")
    private Production production;

    @ManyToOne(targetEntity = ActivityStatus.class)
    @JoinColumn(name = "fk_activityStatuses_id")
    private ActivityStatus activityStatus;

    @ManyToOne(targetEntity = ActivityManager.class)
    @JoinColumn(name = "fk_activityManagers_id")
    private ActivityManager activityManager;

}
