package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.OrderDto;
import com.MagicCandy.AppQuiromar.entity.Order;
import com.MagicCandy.AppQuiromar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrderBusinnes {

    @Autowired
    private OrderService orderService;
    private List<Order> orderList;
    private List<OrderDto> orderDtoList = new ArrayList<>();

    public List<OrderDto> findAll(){
        try {
            this.orderList = this.orderService.findAll();
            this.orderList.forEach(order -> {
                OrderDto orderDto = new OrderDto();
                orderDto.setId(order.getId());
                orderDto.setDateRequest(new Date());
                orderDto.setValue(order.getValue());
                orderDto.setQuantity(order.getQuantity());
                orderDto.setDetail(order.getDetail());
                this.orderDtoList.add(orderDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.orderDtoList;
    }

    public String createOrder(OrderDto orderDto){
        String respuesta = "";
        try {
            if (orderDto != null){
                Order order = new Order();
                order.setDateRequest((java.sql.Date) orderDto.getDateRequest());
                order.setValue(orderDto.getValue());
                order.setQuantity(orderDto.getQuantity());
                order.setDetail(orderDto.getDetail());

                System.out.println("@@@@@@@@@" + orderDto.toString());
                this.orderService.create(order);
                respuesta = "Registro exitoso";
            } else {
                respuesta = "Fallo el registro";
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}
