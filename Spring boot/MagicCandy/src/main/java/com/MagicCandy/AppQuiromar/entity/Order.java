package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "date_request", columnDefinition = "DATE")
    private Date dateRequest;

    @Column(name = "value")
    private float value;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;

    @ManyToMany(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "fk_Orders_id"), inverseJoinColumns = @JoinColumn(name = "fk_products_id"))
    private List<Product> productList;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "fk_users_id")
    private User user;

    @ManyToOne(targetEntity = OrderStatus.class)
    @JoinColumn(name = "fk_orderStatuses_id")
    private OrderStatus orderStatus;
}
