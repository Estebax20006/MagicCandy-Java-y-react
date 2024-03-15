package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.ProductionStatusBusinnes;
import com.MagicCandy.AppQuiromar.dtos.ProductionStatusDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.ProductionStatus;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.ProductionStatusImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/ProductionStatus", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ProductionStatusController {

    @Autowired
    ProductionStatusBusinnes productionStatusBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllProductionStatus(){
        Map<String, Object> res = new HashMap<>();
        List<ProductionStatusDto> productionStatusDtoList = this.productionStatusBusinnes.findAll();

        res.put("status", "success");
        res.put("data", productionStatusDtoList);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createProductionStatus(@RequestBody ProductionStatusDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.productionStatusBusinnes.createProductionStatus(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateProductionStatus(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            ProductionStatus productionStatus = new ProductionStatus();
            productionStatus.setId(Integer.parseInt(request.get("id").toString()));
            productionStatus.setName(request.get("name").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
