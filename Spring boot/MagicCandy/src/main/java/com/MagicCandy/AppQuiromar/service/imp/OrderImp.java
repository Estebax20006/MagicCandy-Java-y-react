package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Order;
import com.MagicCandy.AppQuiromar.repository.OrderRepository;
import com.MagicCandy.AppQuiromar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> findAll() throws Exception {
        return this.orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public void create(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        this.orderRepository.delete(order);
    }
}
