package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Insum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumRepository extends JpaRepository<Insum, Integer> {
    @Query(value = "select i From Insum i where i.id= :id")
    public Insum findById(int id);
}
