package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Order;
import java.util.List;

public interface OrderService {
    public List<Order> findAll() throws Exception;
    public Order findById(int id);
    public void create(Order order);
    public void update(Order order);
    public void delete(Order order);
}
