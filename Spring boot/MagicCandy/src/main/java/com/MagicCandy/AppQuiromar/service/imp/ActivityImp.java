package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Activity;
import com.MagicCandy.AppQuiromar.repository.ActivityRepository;
import com.MagicCandy.AppQuiromar.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityImp implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Override
    public List<Activity> findAll() throws Exception {
        return this.activityRepository.findAll();
    }

    @Override
    public Activity findById(int id) {
        return this.activityRepository.findById(id);
    }

    @Override
    public void create(Activity activity) {
        this.activityRepository.save(activity);
    }

    @Override
    public void update(Activity activity) {
        this.activityRepository.save(activity);
    }

    @Override
    public void delete(Activity activity) {
        this.activityRepository.delete(activity);
    }
}
