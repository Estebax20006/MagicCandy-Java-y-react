package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.ActivityManager;
import java.util.List;

public interface ActivityManagerService {
    public List<ActivityManager> findAll() throws Exception;
    public ActivityManager findById(int id);
    public void create(ActivityManager activityManager);
    public void update(ActivityManager activityManager);
    public void delete(ActivityManager activityManager);
}
