package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Activity;
import java.util.List;
public interface ActivityService {
    public List<Activity> findAll() throws Exception;
    public Activity findById(int id);
    public void create(Activity activity);
    public void update(Activity activity);
    public void delete(Activity activity);
}
