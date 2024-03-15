package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.RoleBusinnes;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Role", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class RoleController {
    @Autowired
    RoleBusinnes roleBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>>findAllRole(){
        Map<String, Object> response = new HashMap<>();
        List<RoleDto> roleDtoList = this.roleBusinnes.findAll();

        response.put("status", "succes");
        response.put("data", roleDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createRole(@RequestBody RoleDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.roleBusinnes.createRole(request);
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
            Role role = new Role();
            role.setId(Integer.parseInt(request.get("id").toString()));
            role.setName(request.get("name").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
