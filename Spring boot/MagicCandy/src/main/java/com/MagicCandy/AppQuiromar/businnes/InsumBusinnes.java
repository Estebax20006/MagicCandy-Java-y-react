package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.InsumDto;
import com.MagicCandy.AppQuiromar.entity.Insum;
import com.MagicCandy.AppQuiromar.service.InsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsumBusinnes {

    @Autowired
    private InsumService insumService;
    private List<Insum> insumList;
    private List<InsumDto> insumDtoList;

    public List<InsumDto> findAll(){
        try {
            this.insumList = this.insumService.findAll();
            this.insumList.forEach(insum -> {
                InsumDto insumDto = new InsumDto();
                insumDto.setId(insum.getId());
                insumDto.setName(insum.getName());
                insumDto.setCategory(insum.getCategory());
                insumDto.setQuantity(insum.getQuantity());
                insumDto.setUnit(insum.getUnit());
                this.insumDtoList.add(insumDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.insumDtoList;
    }

    public String createInsum(InsumDto insumDto){
        String respuesta = "";
        try {
            if (insumDto != null){
                Insum insum = new Insum();
                insum.setName(insumDto.getName());
                insum.setCategory(insumDto.getCategory());
                insum.setQuantity(insumDto.getQuantity());
                insum.setUnit(insumDto.getUnit());

                System.out.println("@@@@@@@@" + insumDto.toString());
                this.insumService.create(insum);
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
