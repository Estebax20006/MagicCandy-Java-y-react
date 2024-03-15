package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "senders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    private String Role;

    @OneToMany(targetEntity = Novelty.class, fetch = FetchType.LAZY, mappedBy = "sender")
    private List<Novelty> noveltyList;

}
