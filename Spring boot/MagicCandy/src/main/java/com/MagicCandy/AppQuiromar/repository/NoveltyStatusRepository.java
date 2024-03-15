package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.NoveltyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoveltyStatusRepository extends JpaRepository<NoveltyStatus, Integer> {
    @Query(value = "select ns From NoveltyStatus ns where ns.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public NoveltyStatus findById(int id);
}
