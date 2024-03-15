package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.ProductionStatusDto;
import com.MagicCandy.AppQuiromar.entity.ProductionStatus;
import com.MagicCandy.AppQuiromar.service.ProductionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductionStatusBusinnes {

    @Autowired
    private ProductionStatusService productionStatusService;
    private List<ProductionStatus> productionStatusList;
    private List<ProductionStatusDto> productionStatusDtoList = new ArrayList<>();

    public List<ProductionStatusDto> findAll(){
        try {
            this.productionStatusList = this.productionStatusService.findAll();
            this.productionStatusList.forEach(productionStatus -> {
                ProductionStatusDto productionStatusDto = new ProductionStatusDto();
                productionStatusDto.setId(productionStatus.getId());
                productionStatusDto.setName(productionStatus.getName());
                this.productionStatusDtoList.add(productionStatusDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.productionStatusDtoList;
    }

    public String createProductionStatus(ProductionStatusDto productionStatusDto){
        String respuesta = "";
        try {
            if (productionStatusDto != null){
                ProductionStatus productionStatus = new ProductionStatus();
                productionStatus.setName(productionStatusDto.getName());

                System.out.println("@@@@@@@@@" + productionStatusDto.toString());
                this.productionStatusService.create(productionStatus);
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
