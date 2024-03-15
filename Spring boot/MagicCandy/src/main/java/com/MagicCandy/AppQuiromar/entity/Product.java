package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name ="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "category")
    private String category;

    @Column (name = "unit_price")
    private int unitPrice;

    @Column (name = "quantity")
    private int quantity;

    @Lob
    @Column(name = "product_image", columnDefinition = "BLOB")
    private byte[] productImage;

    @ManyToMany(targetEntity = Inventory.class, fetch = FetchType.LAZY)
    @JoinTable(name = "products_inventories", joinColumns = @JoinColumn(name = "fk_products_id"), inverseJoinColumns = @JoinColumn(name = "fk_inventories_id"))
    private List<Inventory> inventoryList;

}
