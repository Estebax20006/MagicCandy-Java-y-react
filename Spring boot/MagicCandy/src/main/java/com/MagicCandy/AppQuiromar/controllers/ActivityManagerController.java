package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.ActivityManagerBusinnes;
import com.MagicCandy.AppQuiromar.dtos.ActivityManagerDto;
import com.MagicCandy.AppQuiromar.entity.ActivityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/ActivityManager", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ActivityManagerController {

    @Autowired
    ActivityManagerBusinnes activityManagerBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllActivityManager(){

        Map<String, Object> response = new HashMap<>();
        List<ActivityManagerDto> activityManagerDtoList = this.activityManagerBusinnes.findAll();

        response.put("status", "success");
        response.put("data", activityManagerDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createActivityManager(@RequestBody ActivityManagerDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try {
            valor = this.activityManagerBusinnes.createActivityManager(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateActivityManager(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            ActivityManager activityManager = new ActivityManager();
            activityManager.setId(Integer.parseInt(request.get("id").toString()));
            activityManager.setName(request.get("name").toString());
            activityManager.setLastName(request.get("last_name").toString());
            activityManager.setRole(request.get("role").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
