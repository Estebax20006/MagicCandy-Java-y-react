package com.MagicCandy.AppQuiromar.controllers;

import com.MagicCandy.AppQuiromar.businnes.ProductBusinnes;
import com.MagicCandy.AppQuiromar.dtos.ProductDto;
import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Product;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.imp.ProductImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Product", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductBusinnes productBusinnes;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllProduct(){
        Map<String, Object> response = new HashMap<>();
        List<ProductDto> productDtoList = this.productBusinnes.findAll();

        response.put("status", "success");
        response.put("data", productDtoList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createProduct(@RequestBody ProductDto request){
        String valor = "";
        Map<String, Object> response = new HashMap<>();
        try{
            valor = this.productBusinnes.createProduct(request);
            response.put("status", "Succes");
            response.put("msm", valor);
        } catch (Exception e){
            response.put("status", valor);
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateProduct(@RequestBody Map<String, Object> request){
        Map<String, Object> response = new HashMap<>();
        try {
            Product product = new Product();
            product.setId(Integer.parseInt(request.get("id").toString()));
            product.setName(request.get("name").toString());
            product.setCategory(request.get("category").toString());
            product.setUnitPrice(Integer.parseInt(request.get("unit_price").toString()));
            product.setQuantity(Integer.parseInt(request.get("quantity").toString()));

            response.put("status", "Susses");
            response.put("msm", "Actualizacion exitosa");
        } catch (Exception e){
            response.put("status", "Failed");
            response.put("msm", "Fallo exitoso por" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
