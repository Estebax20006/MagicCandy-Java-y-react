package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.ProductionDto;
import com.MagicCandy.AppQuiromar.entity.Production;
import com.MagicCandy.AppQuiromar.service.ProductService;
import com.MagicCandy.AppQuiromar.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProductionBusinnes {

    @Autowired
    private ProductionService productionService;
    private List<Production> productionList;
    private List<ProductionDto> productionDtoList = new ArrayList<>();

    public List<ProductionDto> findAll(){
        try {
            this.productionList = this.productionService.findAll();
            this.productionList.forEach(production -> {
                ProductionDto productionDto = new ProductionDto();
                productionDto.setId(production.getId());
                productionDto.setStartDate(new Date());
                productionDto.setEndDate(new Date());
                productionDto.setProductProduce(production.getProductProduce());
                productionDto.setQuantityProduce(production.getQuantityProduce());
                productionDto.setLot(production.getLot());
                productionDto.setProductQuality(production.getProductQuality());
                productionDto.setObservations(production.getObservations());
                this.productionDtoList.add(productionDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.productionDtoList;
    }

    public String createProduction(ProductionDto productionDto){
        String respuesta = "";
        try {
            if (productionDto != null){
                Production production = new Production();
                production.setStartDate(productionDto.getStartDate());
                production.setEndDate(productionDto.getEndDate());
                production.setProductProduce(productionDto.getProductProduce());
                production.setQuantityProduce(productionDto.getQuantityProduce());
                production.setLot(productionDto.getLot());
                production.setProductQuality(productionDto.getProductQuality());
                production.setObservations(productionDto.getObservations());

                System.out.println("@@@@@@@@@" + productionDto.toString());
                this.productionService.create(production);
                respuesta = "Registro exitoso";
            } else {
                respuesta = "Fallo el registro";
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

}
