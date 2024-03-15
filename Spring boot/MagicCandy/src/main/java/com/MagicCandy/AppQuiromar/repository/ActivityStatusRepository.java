package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.ActivityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityStatusRepository extends JpaRepository<ActivityStatus, Integer> {
    @Query(value = "select as From ActivityStatus as where as.id= :id")
    public ActivityStatus findById(int id);
}
