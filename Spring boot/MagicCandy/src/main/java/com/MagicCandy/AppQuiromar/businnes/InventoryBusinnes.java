package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.InventoryDto;
import com.MagicCandy.AppQuiromar.entity.Inventory;
import com.MagicCandy.AppQuiromar.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InventoryBusinnes {

    @Autowired
    private InventoryService inventoryService;
    private List<Inventory> inventoryList;
    private List<InventoryDto> inventoryDtoList = new ArrayList<>();

    public List<InventoryDto> findAll(){
        try {
            this.inventoryList = this.inventoryService.findAll();
            this.inventoryList.forEach(inventory -> {
                InventoryDto inventoryDto = new InventoryDto();
                inventoryDto.setId(inventory.getId());
                inventoryDto.setEntryDate(new Date());
                inventoryDto.setEntryQuantity(inventory.getEntryQuantity());
                inventoryDto.setExpirationDate(new Date());
                inventoryDto.setTotalQuantity(inventory.getTotalQuantity());
                inventoryDto.setExitDate(new Date());
                inventoryDto.setExitDescription(inventory.getExitDescription());
                inventoryDto.setExitQuantity(inventory.getExitQuantity());
                this.inventoryDtoList.add(inventoryDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.inventoryDtoList;
    }

    public String createInventory(InventoryDto inventoryDto){
        String respuesta = "";
        try {
            if (inventoryDto != null){
                Inventory inventory = new Inventory();
                inventory.setEntryDate((java.sql.Date) inventoryDto.getEntryDate());
                inventory.setEntryQuantity(inventoryDto.getEntryQuantity());
                inventory.setExpirationDate((java.sql.Date) inventoryDto.getExpirationDate());
                inventory.setTotalQuantity(inventoryDto.getTotalQuantity());
                inventory.setExitDate((java.sql.Date) inventoryDto.getExitDate());
                inventory.setExitDescription(inventoryDto.getExitDescription());
                inventory.setExitQuantity(inventoryDto.getExitQuantity());

                System.out.println("@@@@@@@@@" + inventoryDto.toString());
                this.inventoryService.create(inventory);
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
