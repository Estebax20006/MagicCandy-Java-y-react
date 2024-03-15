package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query(value = "select s From Sale s where s.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public Sale findById(int id);
}
