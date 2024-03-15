package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "pkid")
   private int id;

   @Column(name = "nombre")
   private String name;

   @OneToMany(targetEntity = User.class, fetch = FetchType.LAZY, mappedBy = "role")
   private List<User> userList;
}
