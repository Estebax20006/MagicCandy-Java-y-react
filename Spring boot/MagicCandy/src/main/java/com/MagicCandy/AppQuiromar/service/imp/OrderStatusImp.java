package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.OrderStatus;
import com.MagicCandy.AppQuiromar.repository.OrderStatusRepository;
import com.MagicCandy.AppQuiromar.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusImp implements OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Override
    public List<OrderStatus> findAll() throws Exception {
        return this.orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus findById(int id) {
        return this.orderStatusRepository.findById(id);
    }

    @Override
    public void create(OrderStatus orderStatus) {
        this.orderStatusRepository.save(orderStatus);
    }

    @Override
    public void update(OrderStatus orderStatus) {
        this.orderStatusRepository.save(orderStatus);
    }

    @Override
    public void delete(OrderStatus orderStatus) {
        this.orderStatusRepository.delete(orderStatus);
    }
}
