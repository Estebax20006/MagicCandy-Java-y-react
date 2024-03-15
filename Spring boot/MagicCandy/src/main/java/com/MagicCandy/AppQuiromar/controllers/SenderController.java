package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.SenderBusinnes;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.dtos.SenderDto;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.entity.Sender;
import com.MagicCandy.AppQuiromar.service.imp.SenderImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Sender", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class SenderController {

    @Autowired
    SenderBusinnes senderBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllSender(){
        Map<String, Object> response = new HashMap<>();
        List<SenderDto> senderDtoList = this.senderBusinnes.findAll();

        response.put("status", "success");
        response.put("data", senderDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createSender(@RequestBody SenderDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.senderBusinnes.createSender(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateSender(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Sender sender = new Sender();
            sender.setId(Integer.parseInt(request.get("id").toString()));
            sender.setName(request.get("name").toString());
            sender.setLastName(request.get("last_name").toString());
            sender.setRole(request.get("role").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
