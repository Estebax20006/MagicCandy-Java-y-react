package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    public List<OrderStatus> findAll() throws Exception;
    public OrderStatus findById(int id);
    public void create(OrderStatus orderStatus);
    public void update(OrderStatus orderStatus);
    public void delete(OrderStatus orderStatus);
}
