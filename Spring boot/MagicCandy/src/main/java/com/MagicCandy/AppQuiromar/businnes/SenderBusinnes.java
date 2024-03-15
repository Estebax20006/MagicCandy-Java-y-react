package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.SenderDto;
import com.MagicCandy.AppQuiromar.entity.Sender;
import com.MagicCandy.AppQuiromar.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SenderBusinnes {

    @Autowired
    private SenderService senderService;
    private List<Sender> senderList;
    private List<SenderDto> senderDtoList = new ArrayList<>();

    public List<SenderDto> findAll(){
        try {
            this.senderList = this.senderService.findAll();
            this.senderList.forEach(sender -> {
                SenderDto senderDto = new SenderDto();
                senderDto.setId(sender.getId());
                senderDto.setName(sender.getName());
                senderDto.setLastName(sender.getLastName());
                senderDto.setRole(sender.getRole());
                this.senderDtoList.add(senderDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.senderDtoList;
    }

    public String createSender(SenderDto senderDto){
        String respuesta = "";
        try {
            if (senderDto != null){
                Sender sender = new Sender();
                sender.setName(senderDto.getName());
                sender.setLastName(senderDto.getLastName());
                sender.setRole(senderDto.getRole());

                System.out.println("@@@@@@@@@" + senderDto.toString());
                this.senderService.create(sender);
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
