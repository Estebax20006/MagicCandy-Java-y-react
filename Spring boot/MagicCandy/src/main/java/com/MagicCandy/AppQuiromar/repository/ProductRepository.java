package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p From Product p where p.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public Product findById(int id);
}
