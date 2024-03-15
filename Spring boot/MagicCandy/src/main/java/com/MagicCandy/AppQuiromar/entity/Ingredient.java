package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "set_amount")
    private String setAmount; //Cantidad reservada

    @ManyToOne(targetEntity = Insum.class)
    @JoinColumn(name = "fk_supplies_id")
    private Insum insum;

    @ManyToOne(targetEntity = Production.class)
    @JoinColumn(name = "fk_productions_id")
    private Production production;

}

