package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.NoveltyStatusBusinnes;
import com.MagicCandy.AppQuiromar.dtos.NoveltyStatusDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.NoveltyStatus;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.NoveltyStatusImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/NoveltyStatus", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class NoveltyStatusController {

    @Autowired
    NoveltyStatusBusinnes noveltyStatusBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllNoveltyStatus(){
        Map<String, Object> response = new HashMap<>();
        List<NoveltyStatusDto> noveltyStatusDtoList = this.noveltyStatusBusinnes.findAll();

        response.put("status", "success");
        response.put("data", noveltyStatusDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createNoveltyStatus(@RequestBody NoveltyStatusDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.noveltyStatusBusinnes.createNoveltyStatus(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateNoveltyStatus(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            NoveltyStatus noveltyStatus = new NoveltyStatus();
            noveltyStatus.setId(Integer.parseInt(request.get("id").toString()));
            noveltyStatus.setName(request.get("name").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
