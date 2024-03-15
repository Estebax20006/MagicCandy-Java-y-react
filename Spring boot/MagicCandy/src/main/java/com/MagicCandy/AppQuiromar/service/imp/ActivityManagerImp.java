package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.ActivityManager;
import com.MagicCandy.AppQuiromar.repository.ActivityManagerRepository;
import com.MagicCandy.AppQuiromar.service.ActivityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityManagerImp implements ActivityManagerService {
    @Autowired
    private ActivityManagerRepository activityManagerRepository;
    @Override
    public List<ActivityManager> findAll() throws Exception {
        return this.activityManagerRepository.findAll();
    }

    @Override
    public ActivityManager findById(int id) {
        return this.activityManagerRepository.findById(id);
    }

    @Override
    public void create(ActivityManager activityManager) {
        this.activityManagerRepository.save(activityManager);
    }

    @Override
    public void update(ActivityManager activityManager) {
        this.activityManagerRepository.save(activityManager);
    }

    @Override
    public void delete(ActivityManager activityManager) {
        this.activityManagerRepository.delete(activityManager);
    }
}
