package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.OrderStatusBusinnes;
import com.MagicCandy.AppQuiromar.dtos.OrderStatusDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.OrderStatus;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.OrderStatusImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/OrderStatus", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class OrderStatusController {

    @Autowired
    OrderStatusBusinnes orderStatusBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllOrderStatus(){
        Map<String, Object> response = new HashMap<>();
        List<OrderStatusDto> orderStatusDtoList = this.orderStatusBusinnes.findAll();

        response.put("status", "success");
        response.put("data", orderStatusDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createOrderStatus(@RequestBody OrderStatusDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.orderStatusBusinnes.createOrderStatus(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateRole(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(Integer.parseInt(request.get("id").toString()));
            orderStatus.setName(request.get("name").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
