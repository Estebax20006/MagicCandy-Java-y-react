package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.NoveltyBusinnes;
import com.MagicCandy.AppQuiromar.dtos.NoveltyDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Novelty;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.NoveltyImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Novelty", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class NoveltyController {

    @Autowired
    NoveltyBusinnes noveltyBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllNovelty(){
        Map<String, Object> response = new HashMap<>();
        List<NoveltyDto> noveltyDtoList = this.noveltyBusinnes.findAll();

        response.put("status", "success");
        response.put("data", noveltyDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createNovelty(@RequestBody NoveltyDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.noveltyBusinnes.createNovelty(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateNovelty(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Novelty novelty = new Novelty();
            novelty.setId(Integer.parseInt(request.get("id").toString()));
            novelty.setSubject(request.get("subject").toString());
            novelty.setDate(Date.valueOf(request.get("date").toString()));
            novelty.setTime(Date.valueOf(request.get("time").toString()));
            novelty.setComment(request.get("comment").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
