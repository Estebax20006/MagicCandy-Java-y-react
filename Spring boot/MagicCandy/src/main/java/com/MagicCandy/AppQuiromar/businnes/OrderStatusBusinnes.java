package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.OrderStatusDto;
import com.MagicCandy.AppQuiromar.entity.OrderStatus;
import com.MagicCandy.AppQuiromar.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderStatusBusinnes {

    @Autowired
    private OrderStatusService orderStatusService;
    private List<OrderStatus> orderStatusList;
    private List<OrderStatusDto> orderStatusDtoList = new ArrayList<>();

    public List<OrderStatusDto> findAll(){
        try {
            this.orderStatusList = this.orderStatusService.findAll();
            this.orderStatusList.forEach(orderStatus -> {
                OrderStatusDto orderStatusDto = new OrderStatusDto();
                orderStatusDto.setId(orderStatus.getId());
                orderStatusDto.setName(orderStatus.getName());
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.orderStatusDtoList;
    }

    public String createOrderStatus(OrderStatusDto orderStatusDto){
        String respuesta = "";
        try {
            if (orderStatusDto != null){
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setName(orderStatusDto.getName());

                System.out.println("@@@@@@@@@" + orderStatusDto.toString());
                this.orderStatusService.create(orderStatus);
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
