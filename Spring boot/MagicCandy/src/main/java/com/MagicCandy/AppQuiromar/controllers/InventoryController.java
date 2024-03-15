package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.InventoryBusinnes;
import com.MagicCandy.AppQuiromar.dtos.InventoryDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Inventory;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.InventoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Inventory", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class InventoryController {

    @Autowired
    InventoryBusinnes inventoryBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>>findAllInventory(){
        Map<String, Object> response = new HashMap<>();
        List<InventoryDto> inventoryDtoList = this.inventoryBusinnes.findAll();

        response.put("status", "succes");
        response.put("data", inventoryDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createInventory(@RequestBody InventoryDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.inventoryBusinnes.createInventory(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateInventory(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Inventory inventory = new Inventory();
            inventory.setId(Integer.parseInt(request.get("id").toString()));
            inventory.setEntryDate(Date.valueOf(request.get("entry_date").toString()));
            inventory.setEntryQuantity(Integer.parseInt(request.get("entry_quantity").toString()));
            inventory.setExpirationDate(Date.valueOf(request.get("expiration_date").toString()));
            inventory.setTotalQuantity(Integer.parseInt(request.get("total_quantity").toString()));
            inventory.setExitDate(Date.valueOf(request.get("exit_date").toString()));
            inventory.setExitDescription(request.get("exit_description").toString());
            inventory.setExitQuantity(Integer.parseInt(request.get("exit_quantity").toString()));

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
