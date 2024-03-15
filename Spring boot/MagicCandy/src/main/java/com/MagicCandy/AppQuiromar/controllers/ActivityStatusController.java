package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.ActivityStatusBusinnes;
import com.MagicCandy.AppQuiromar.dtos.ActivityStatusDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.ActivityStatus;
import com.MagicCandy.AppQuiromar.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/ActivityStatus", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ActivityStatusController {
    @Autowired
    ActivityStatusBusinnes activityStatusBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllActivityStatus(){

        Map<String, Object> response = new HashMap<>();
        List<ActivityStatusDto> activityStatusDtoList = this.activityStatusBusinnes.findAll();

        response.put("status", "success");
        response.put("data", activityStatusDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createActivityStatus(@RequestBody ActivityStatusDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.activityStatusBusinnes.createActivityStatus(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateActivityStatus(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            ActivityStatus activityStatus = new ActivityStatus();
            activityStatus.setId(Integer.parseInt(request.get("id").toString()));
            activityStatus.setName(request.get("name").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
