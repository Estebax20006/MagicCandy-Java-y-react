package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.InsumBusinnes;
import com.MagicCandy.AppQuiromar.dtos.InsumDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Insum;
import com.MagicCandy.AppQuiromar.entity.Inventory;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.InsumImp;
import com.MagicCandy.AppQuiromar.service.imp.InventoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Insum", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class InsumController {

    @Autowired
    InsumBusinnes insumBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>>findAllInsum(){
        Map<String, Object> response = new HashMap<>();
        List<InsumDto> insumDtoList = this.insumBusinnes.findAll();

        response.put("status", "succes");
        response.put("data", insumDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createInsum(@RequestBody InsumDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.insumBusinnes.createInsum(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateInsum(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Insum insum = new Insum();
            insum.setId(Integer.parseInt(request.get("id").toString()));
            insum.setName(request.get("name").toString());
            insum.setCategory(request.get("category").toString());
            insum.setQuantity(Integer.parseInt(request.get("quantity").toString()));
            insum.setUnit(request.get("unit").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
