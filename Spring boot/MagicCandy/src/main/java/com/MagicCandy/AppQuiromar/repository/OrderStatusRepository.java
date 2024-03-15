package com.MagicCandy.AppQuiromar.repository;

import com.MagicCandy.AppQuiromar.entity.OrderStatus;
import com.MagicCandy.AppQuiromar.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
    @Query(value = "select os From OrderStatus os where os.id= :id") //nativaQuery = true, para cundo la consulta se va a hacer en lenguaje SQL
    public OrderStatus findById(int id);
}
