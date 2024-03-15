package com.MagicCandy.AppQuiromar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "productions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "start_date", columnDefinition = "DATE")
    private Date startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private Date endDate;

    @Column(name = "product_produce")
    private String productProduce;

    @Column(name = "quantity_produce")
    private int quantityProduce;

    @Column(name = "lot")
    private String lot;

    @Column(name = "product_quality")
    private String productQuality;

    @Column(name = "observations")
    private String observations;

    @OneToMany(targetEntity = Ingredient.class, fetch = FetchType.LAZY, mappedBy = "production")
    private List<Ingredient> ingredientList;

    @ManyToOne(targetEntity = ProductionStatus.class)
    @JoinColumn(name = "fk_productionStatements_id")
    private ProductionStatus productionStatus;

    @OneToMany(targetEntity = Activity.class, fetch = FetchType.LAZY, mappedBy = "production")
    private List<Activity> activityList;

    @OneToMany(targetEntity = Novelty.class, fetch = FetchType.LAZY, mappedBy = "production")
    private List<Novelty> noveltyList;
}
