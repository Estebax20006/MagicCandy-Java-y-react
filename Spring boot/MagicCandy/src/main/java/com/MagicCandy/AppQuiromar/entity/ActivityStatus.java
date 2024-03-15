package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "activityStatuses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Activity.class, fetch = FetchType.LAZY, mappedBy = "activityStatus")
    private List<Activity> activityList;
}
