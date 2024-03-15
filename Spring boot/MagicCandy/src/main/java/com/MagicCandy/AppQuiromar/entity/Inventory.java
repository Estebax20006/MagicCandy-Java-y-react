package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "inventories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pkid")
        private int id;

        @Column(name = "entry_date", columnDefinition = "DATE")
        private Date entryDate;

        @Column(name = "entry_quantity")
        private int entryQuantity;

        @Column(name = "expiration_date", columnDefinition = "DATE")
        private Date expirationDate;

        @Column(name = "total_quantity")
        private int totalQuantity;

        @Column(name = "exit_date", columnDefinition = "DATE")
        private Date exitDate;

        @Column(name = "exit_description")
        private String exitDescription;

        @Column(name = "exit_quantity")
        private int exitQuantity;

        @ManyToMany(targetEntity = Insum.class, fetch = FetchType.LAZY)
        @JoinTable(name = "inventories_supplies", joinColumns = @JoinColumn(name = "fk_supplies_id"), inverseJoinColumns = @JoinColumn(name = "fk_inventories_id"))
        private List<Insum> insumList;

}
