package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.ActivityManager;
import com.MagicCandy.AppQuiromar.entity.ActivityStatus;
import com.MagicCandy.AppQuiromar.entity.Production;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

    private int id;

    private String title;

    private String description;

    private Data startDate;

    private Data endDate;

    private Production production;

    private ActivityStatus activityStatus;

    private ActivityManager activityManager;
    
}
