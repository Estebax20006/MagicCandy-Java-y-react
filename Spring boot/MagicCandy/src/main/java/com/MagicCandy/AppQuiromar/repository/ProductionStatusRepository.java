package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.ProductionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionStatusRepository extends JpaRepository<ProductionStatus, Integer> {
    @Query(value = "select ps From ProductionStatus ps where ps.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public ProductionStatus findById(int id);
}
