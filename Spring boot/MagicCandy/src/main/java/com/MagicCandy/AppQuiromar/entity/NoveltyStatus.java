package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.io.Serializable;

@Entity
@Table(name = "noveltyStates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoveltyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Novelty.class, fetch = FetchType.LAZY, mappedBy = "noveltyStatus")
    private List<Novelty> noveltyList;

}
