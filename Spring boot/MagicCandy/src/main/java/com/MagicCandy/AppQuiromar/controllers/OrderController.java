package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.OrderBusinnes;
import com.MagicCandy.AppQuiromar.dtos.OrderDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Order;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.OrderImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Order", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderBusinnes orderBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllOrder(){
        Map<String, Object> res = new HashMap<>();
        List<OrderDto> listOrders = this.orderBusinnes.findAll();

        res.put("status", "success");
        res.put("data", listOrders);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody OrderDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.orderBusinnes.createOrder(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateOrder(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Order order = new Order();
            order.setId(Integer.parseInt(request.get("id").toString()));
            order.setDateRequest(Date.valueOf(request.get("date_request").toString()));
            order.setValue(Float.parseFloat(request.get("value").toString()));
            order.setQuantity(Integer.parseInt(request.get("quantity").toString()));
            order.setDetail(request.get("detail").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
