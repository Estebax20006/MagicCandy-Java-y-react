package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Referred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferredRepository extends JpaRepository<Referred, Integer> {
    @Query(value = "select r From Referred r where r.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public Referred findById(int id);
}
