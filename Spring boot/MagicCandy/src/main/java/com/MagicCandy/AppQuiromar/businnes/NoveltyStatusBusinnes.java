package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.NoveltyStatusDto;
import com.MagicCandy.AppQuiromar.entity.NoveltyStatus;
import com.MagicCandy.AppQuiromar.service.NoveltyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoveltyStatusBusinnes {

    @Autowired
    private NoveltyStatusService noveltyStatusService;
    private List<NoveltyStatus> noveltyStatusList;
    private List<NoveltyStatusDto> noveltyStatusDtoList = new ArrayList<>();

    public List<NoveltyStatusDto> findAll(){
        try {
            this.noveltyStatusList = this.noveltyStatusService.findAll();
            this.noveltyStatusList.forEach(noveltyStatus -> {
                NoveltyStatusDto noveltyStatusDto = new NoveltyStatusDto();
                noveltyStatusDto.setId(noveltyStatus.getId());
                noveltyStatusDto.setName(noveltyStatus.getName());
                this.noveltyStatusDtoList.add(noveltyStatusDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.noveltyStatusDtoList;
    }
    public String createNoveltyStatus(NoveltyStatusDto noveltyStatusDto){
        String respuesta = "";
        try {
            if (noveltyStatusDto != null){
                NoveltyStatus noveltyStatus = new NoveltyStatus();
                noveltyStatus.setName(noveltyStatus.getName());

                System.out.println("@@@@@@@@" + noveltyStatusDto.toString());
                this.noveltyStatusService.create(noveltyStatus);
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
