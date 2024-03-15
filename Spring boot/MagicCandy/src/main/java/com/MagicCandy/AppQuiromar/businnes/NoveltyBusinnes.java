package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.NoveltyDto;
import com.MagicCandy.AppQuiromar.entity.Novelty;
import com.MagicCandy.AppQuiromar.service.NoveltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class NoveltyBusinnes {

    @Autowired
    private NoveltyService noveltyService;
    private List<Novelty> noveltyList;
    private List<NoveltyDto> noveltyDtoList = new ArrayList<>();

    public List<NoveltyDto> findAll(){
        try {
            this.noveltyList = this.noveltyService.findAll();
            this.noveltyList.forEach(novelty -> {
                NoveltyDto noveltyDto = new NoveltyDto();
                noveltyDto.setId(novelty.getId());
                noveltyDto.setSubject(novelty.getSubject());
                noveltyDto.setDate(Date.valueOf(novelty.getDate().toLocalDate()));
                noveltyDto.setTime(Date.valueOf(novelty.getTime().toLocalDate()));
                noveltyDto.setComment(novelty.getComment());
                this.noveltyDtoList.add(noveltyDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.noveltyDtoList;
    }

    public String createNovelty(NoveltyDto noveltyDto){
        String respuesta = "";
        try {
            if (noveltyDto != null){
                Novelty novelty = new Novelty();
                novelty.setSubject(noveltyDto.getSubject());
                novelty.setDate(noveltyDto.getDate());
                novelty.setTime(noveltyDto.getTime());
                novelty.setComment(noveltyDto.getComment());

                System.out.println("@@@@@@@@@" + noveltyDto.toString());
                this.noveltyService.create(novelty);
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
