package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "activityManagers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column (name = "name")
    private String name; //Nombre responsable

    @Column (name = "last_name")
    private String lastName; //Apellido responsable

    @Column (name = "role")
    private String role;

    @OneToMany(targetEntity = Activity.class, fetch = FetchType.LAZY, mappedBy = "activityManager")
    private List<Activity> activityList;
}
