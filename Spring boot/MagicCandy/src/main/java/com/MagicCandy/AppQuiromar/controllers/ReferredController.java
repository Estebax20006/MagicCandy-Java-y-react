package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.ReferredBusinnes;
import com.MagicCandy.AppQuiromar.dtos.ReferredDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Referred;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.ReferredImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Referred", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ReferredController {

    @Autowired
    ReferredBusinnes referredBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllReferred(){
        Map<String, Object> response = new HashMap<>();
        List<ReferredDto> referredDtoList = this.referredBusinnes.findAll();

        response.put("status", "success");
        response.put("data", referredDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createReferred(@RequestBody ReferredDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.referredBusinnes.createReferred(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateReferred(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Referred referred = new Referred();
            referred.setId(Integer.parseInt(request.get("id").toString()));
            referred.setName(request.get("name").toString());
            referred.setLastName(request.get("last_name").toString());
            referred.setRole(request.get("role").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
