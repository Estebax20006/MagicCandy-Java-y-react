package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Lob
    @Column(name = "receipt", columnDefinition = "BLOB")
    private byte[] receipt;

    @Column(name = "value")
    private int value;

    @Column(name = "delivery_quantity")
    private int deliveryQuantity;

    @Column(name = "sale_date", columnDefinition = "DATE")
    private Date saleDate;

    @Column(name = "sale_time", columnDefinition = "DATE")
    private Time saleTime;

    @Column(name = "detail", columnDefinition = "TEXT")
    private String Detail;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "fk_Orders_id")
    private Order order;
}
