package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Integer> {
    @Query(value = "select s From Sender s where s.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public Sender findById(int id);
}
