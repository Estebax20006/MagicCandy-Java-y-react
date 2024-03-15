package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.ProductionBusinnes;
import com.MagicCandy.AppQuiromar.dtos.ProductionDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Production;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.ProductionImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Production", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ProductionController {

    @Autowired
    ProductionBusinnes productionBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllProduction(){
        Map<String, Object> response = new HashMap<>();
        List<ProductionDto> productionDtoList = this.productionBusinnes.findAll();

        response.put("status", "success");
        response.put("data", productionDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createProduction(@RequestBody ProductionDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.productionBusinnes.createProduction(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateProduction(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Production production = new Production();
            production.setId(Integer.parseInt(request.get("id").toString()));
            production.setStartDate(Date.from(Instant.parse(request.get("start_date").toString())));
            production.setEndDate(Date.from(Instant.parse(request.get("end_date").toString())));
            production.setProductProduce(request.get("name").toString());
            production.setQuantityProduce(Integer.parseInt(request.get("quantity_produce").toString()));
            production.setLot(request.get("lot").toString());
            production.setProductQuality(request.get("product_quality").toString());
            production.setObservations(request.get("observations").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
