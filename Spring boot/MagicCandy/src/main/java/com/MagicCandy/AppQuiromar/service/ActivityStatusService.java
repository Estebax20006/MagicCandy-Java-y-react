package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.ActivityStatus;
import java.util.List;

public interface ActivityStatusService {
    public List<ActivityStatus> findAll() throws Exception;
    public ActivityStatus findById(int id);
    public void create(ActivityStatus activityStatus);
    public void update(ActivityStatus activityStatus);
    public void delete(ActivityStatus activityStatus);
}
