package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.ActivityBusinnes;
import com.MagicCandy.AppQuiromar.dtos.ActivityDto;
import com.MagicCandy.AppQuiromar.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Activity", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ActivityController {

    @Autowired
    ActivityBusinnes activityBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllActivity(){

        Map<String, Object> response = new HashMap<>();
        List<ActivityDto> listActivities = this.activityBusinnes.findAll();

        response.put("status", "success");
        response.put("data", listActivities);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createActivity(@RequestBody ActivityDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try {
            valor = this.activityBusinnes.createActivity(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" +e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public  ResponseEntity<Map<String, Object>> updateActivity(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Activity activity = new Activity();
            activity.setId(Integer.parseInt(request.get("id").toString()));
            activity.setTitle(request.get("title").toString());
            activity.setDescription(request.get("description").toString());
            activity.setStartDate(new Date());
            activity.setEndDate(new Date());
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
