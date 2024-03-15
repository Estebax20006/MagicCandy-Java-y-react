package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u From User u where u.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public User findById(int id);
}
