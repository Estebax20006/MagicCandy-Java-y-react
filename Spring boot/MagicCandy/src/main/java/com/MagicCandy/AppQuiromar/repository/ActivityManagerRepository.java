package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.ActivityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityManagerRepository extends JpaRepository <ActivityManager,Integer>{
    @Query(value = "select am From ActivityManager am where am.id= :id")
    public ActivityManager findById(int id);
}
