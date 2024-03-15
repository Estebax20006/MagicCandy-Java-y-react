package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.ActivityStatusDto;
import com.MagicCandy.AppQuiromar.entity.ActivityStatus;
import com.MagicCandy.AppQuiromar.service.ActivityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityStatusBusinnes {

    @Autowired
    private ActivityStatusService activityStatusService;
    private List<ActivityStatus> activityStatusList;
    private List<ActivityStatusDto> activityStatusDtoList = new ArrayList<>();

    public List<ActivityStatusDto> findAll(){
        try {
            this.activityStatusList = this.activityStatusService.findAll();
            this.activityStatusList.forEach(activityStatus -> {
                ActivityStatusDto activityStatusDto = new ActivityStatusDto();
                activityStatusDto.setId(activityStatus.getId());
                activityStatusDto.setName(activityStatus.getName());
                this.activityStatusDtoList.add(activityStatusDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.activityStatusDtoList;
    }

    public String createActivityStatus(ActivityStatusDto activityStatusDto){
        String respuesta = "";
        try {
            if (activityStatusDto != null){
                ActivityStatus activityStatus = new ActivityStatus();
                activityStatus.setName(activityStatusDto.getName());

                System.out.println("@@@@@@@@" + activityStatusDto.toString());
                this.activityStatusService.create(activityStatus);
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
