package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.ActivityManagerDto;
import com.MagicCandy.AppQuiromar.entity.ActivityManager;
import com.MagicCandy.AppQuiromar.service.ActivityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityManagerBusinnes {

    @Autowired
    private ActivityManagerService activityManagerService;
    private List<ActivityManager> activityManagerList;
    private List<ActivityManagerDto> activityManagerDtoList = new ArrayList<>();

    public List<ActivityManagerDto> findAll(){
        try {
            this.activityManagerList = this.activityManagerService.findAll();
            this.activityManagerList.forEach(activityManager -> {
                ActivityManagerDto activityManagerDto = new ActivityManagerDto();
                activityManagerDto.setId(activityManager.getId());
                activityManagerDto.setName(activityManager.getName());
                activityManagerDto.setLastName(activityManager.getLastName());
                activityManagerDto.setRole(activityManager.getRole());
                this.activityManagerDtoList.add(activityManagerDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.activityManagerDtoList;
    }

    public String createActivityManager(ActivityManagerDto activityManagerDto){
        String respuesta = "";
        try {
            if (activityManagerDto != null){
                ActivityManager activityManager = new ActivityManager();
                activityManager.setName(activityManagerDto.getName());
                activityManager.setLastName(activityManagerDto.getLastName());
                activityManager.setLastName(activityManagerDto.getLastName());
                activityManager.setRole(activityManagerDto.getRole());

                System.out.println("@@@@@@@" + activityManagerDto.toString());
                this.activityManagerService.create(activityManager);
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
