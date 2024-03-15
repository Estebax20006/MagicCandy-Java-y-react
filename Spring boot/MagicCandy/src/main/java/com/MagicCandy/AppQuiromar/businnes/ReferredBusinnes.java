package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.ReferredDto;
import com.MagicCandy.AppQuiromar.entity.Referred;
import com.MagicCandy.AppQuiromar.service.ReferredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReferredBusinnes {

    @Autowired
    private ReferredService referredService;
    private List<Referred> referredList;
    private List<ReferredDto> referredDtoList = new ArrayList<>();

    public List<ReferredDto> findAll(){
        try {
            this.referredList = this.referredService.findAll();
            this.referredList.forEach(referred -> {
                ReferredDto referredDto = new ReferredDto();
                referredDto.setId(referred.getId());
                referredDto.setName(referred.getName());
                referredDto.setLastName(referred.getLastName());
                referredDto.setRole(referred.getRole());
                this.referredDtoList.add(referredDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.referredDtoList;
    }

    public String createReferred(ReferredDto referredDto){
        String respuesta = "";
        try {
            if (referredDto != null){
                Referred referred = new Referred();
                referred.setName(referredDto.getName());
                referred.setLastName(referredDto.getLastName());
                referred.setRole(referredDto.getRole());

                System.out.println("@@@@@@@@@" + referredDto.toString());
                this.referredService.create(referred);
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