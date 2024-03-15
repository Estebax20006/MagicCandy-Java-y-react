package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select o From Order o where o.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public Order findById(int id);
}
