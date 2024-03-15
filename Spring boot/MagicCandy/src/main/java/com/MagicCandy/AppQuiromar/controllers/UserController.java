package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.UserBusinnes;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.dtos.UserDto;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.entity.User;
import com.MagicCandy.AppQuiromar.service.imp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/User", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserBusinnes userBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllUser(){
        Map<String, Object> response = new HashMap<>();
        List<UserDto> userDtoList = this.userBusinnes.findAll();

        response.put("status", "success");
        response.put("data", userDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.userBusinnes.createUser(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            User user = new User();
            user.setId(Integer.parseInt(request.get("id").toString()));
            user.setIdentification(request.get("identification").toString());
            user.setName(request.get("name").toString());
            user.setLastName(request.get("last_name").toString());
            user.setAddress(request.get("address").toString());
            user.setPhoneNumber(request.get("phone_number").toString());
            user.setEmail(request.get("email").toString());
            user.setPassword(request.get("password").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
