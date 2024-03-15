package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "identification")
    private String identification;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "fk_roles_id")
    private Role role;

    @OneToMany(targetEntity = Order.class, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orderList;
}