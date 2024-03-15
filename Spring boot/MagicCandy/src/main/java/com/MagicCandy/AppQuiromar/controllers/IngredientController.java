package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.IngredientBusinnes;
import com.MagicCandy.AppQuiromar.dtos.IngredientDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Ingredient;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.IngredientImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Ingredient", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class IngredientController {

    @Autowired
    IngredientBusinnes ingredientBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllIngredients(){
        Map<String, Object> response = new HashMap<>();
        List<IngredientDto> ingredientDtoList = this.ingredientBusinnes.findAll();

        response.put("status", "success");
        response.put("data", ingredientDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createIngredient(@RequestBody IngredientDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.ingredientBusinnes.createIngredient(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateIngredient(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(Integer.parseInt(request.get("id").toString()));
            ingredient.setSetAmount(request.get("set_amount").toString());

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
