package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.SaleDto;
import com.MagicCandy.AppQuiromar.entity.Sale;
import com.MagicCandy.AppQuiromar.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class SaleBusinnes {

    @Autowired
    private SaleService saleService;
    private List<Sale> saleList;
    private List<SaleDto> saleDtoList = new ArrayList<>();

    public List<SaleDto> findAll(){
        try {
            this.saleList = this.saleService.findAll();
            this.saleList.forEach(sale -> {
                SaleDto saleDto = new SaleDto();
                saleDto.setId(sale.getId());
                saleDto.setReceipt(Arrays.toString(sale.getReceipt()));
                saleDto.setValue(sale.getValue());
                saleDto.setDeliveryQuantity(sale.getDeliveryQuantity());
                saleDto.setSaleDate(new Date());
                saleDto.setSaleTime(new Date());
                saleDto.setDetail(sale.getDetail());
                this.saleDtoList.add(saleDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.saleDtoList;
    }

    public String createSale(SaleDto saleDto){
        String respuesta = "";
        try {
            if (saleDto != null){
                Sale sale = new Sale();
                sale.setReceipt(saleDto.getReceipt().getBytes());
                sale.setValue(saleDto.getValue());
                sale.setDeliveryQuantity(saleDto.getDeliveryQuantity());
                sale.setSaleDate(saleDto.getSaleDate());
                sale.setSaleTime((Time) saleDto.getSaleTime());
                sale.setDetail(saleDto.getDetail());

                System.out.println("@@@@@@@@@" + saleDto.toString());
                this.saleService.create(sale);
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
