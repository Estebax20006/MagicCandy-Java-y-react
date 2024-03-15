package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select r From Role r where r.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public Role findById(int id);
}
