package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.ActivityDto;
import com.MagicCandy.AppQuiromar.entity.Activity;
import com.MagicCandy.AppQuiromar.service.ActivityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ActivityBusinnes {

    @Autowired
    private ActivityService activityService;
    private List<Activity> activityList;
    private List<ActivityDto>  activityDtoList = new ArrayList<>();

    public List<ActivityDto> findAll(){
        try {
            this.activityList = this.activityService.findAll();
            this.activityList.forEach(activity -> {
                ActivityDto activityDto = new ActivityDto();
                activityDto.setId(activity.getId());
                activityDto.setTitle(activity.getTitle());
                activityDto.setDescription(activity.getDescription());
                activityDto.setStartDate((Data) activity.getStartDate());
                activityDto.setEndDate((Data) activity.getEndDate());
                this.activityDtoList.add(activityDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  this.activityDtoList;
    }

    public String createActivity(ActivityDto activityDto){
        String respuesta = "";
        try {
            if (activityDto != null){
                Activity activity = new Activity();
                activity.setTitle(activityDto.getTitle());
                activity.setDescription(activityDto.getDescription());
                activity.setStartDate((Date) activityDto.getStartDate());
                activity.setEndDate((Date) activityDto.getEndDate());

                System.out.println("@@@@@@@@@" + activityDto.toString());
                this.activityService.create(activity);
                respuesta = "Regisro exitoso";
            } else {
                respuesta = "Fallo el registro";
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}
