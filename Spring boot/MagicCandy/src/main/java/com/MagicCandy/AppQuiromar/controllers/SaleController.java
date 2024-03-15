package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.SaleBusinnes;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.dtos.SaleDto;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.entity.Sale;
import com.MagicCandy.AppQuiromar.service.imp.SaleImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Sale", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class SaleController {

    @Autowired
    SaleBusinnes saleBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllSale(){
        Map<String, Object> response = new HashMap<>();
        List<SaleDto> saleDtoList = this.saleBusinnes.findAll();

        response.put("status", "success");
        response.put("data", saleDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createSale(@RequestBody SaleDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.saleBusinnes.createSale(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateSale(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Sale sale = new Sale();
            sale.setId(Integer.parseInt(request.get("id").toString()));
            sale.setReceipt(request.get("receipt").toString().getBytes());
            sale.setValue(Integer.parseInt(request.get("value").toString()));
            sale.setDeliveryQuantity(Integer.parseInt(request.get("delivery_quantity").toString()));
            sale.setSaleDate(Date.from(Instant.parse(request.get("sale_date").toString())));
            sale.setSaleTime(Time.valueOf(request.get("sale_time").toString()));
            sale.setDetail(request.get("name").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
