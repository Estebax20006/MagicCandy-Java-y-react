package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "referrals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Referred {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    private String role;

    @OneToMany(targetEntity = Novelty.class, fetch = FetchType.LAZY, mappedBy = "referred")
    private List<Novelty> noveltyList;
}
