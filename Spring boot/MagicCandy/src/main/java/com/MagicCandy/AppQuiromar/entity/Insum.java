package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "supplies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit")
    private String unit;

    @OneToMany(targetEntity = Ingredient.class, fetch = FetchType.LAZY, mappedBy = "insum")
    private List<Ingredient> ingredientList;

}
