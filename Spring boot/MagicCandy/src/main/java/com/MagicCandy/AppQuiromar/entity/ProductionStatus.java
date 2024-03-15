package com.MagicCandy.AppQuiromar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.io.Serializable;

@Entity
@Table(name = "productionStatements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Production.class, fetch = FetchType.LAZY, mappedBy = "productionStatus")
    private List<Production> productionList;
}
