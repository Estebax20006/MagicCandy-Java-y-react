package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Integer> {
    @Query(value = "select p From Production p where p.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public Production findById(int id);
}
