package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Novelty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoveltyRepository extends JpaRepository<Novelty, Integer> {
    @Query(value = "select n From Novelty n where n.id= :id")
    public Novelty findById(int id);
}
