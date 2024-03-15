package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.ActivityStatus;
import com.MagicCandy.AppQuiromar.repository.ActivityStatusRepository;
import com.MagicCandy.AppQuiromar.service.ActivityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityStatusImp implements ActivityStatusService {
    @Autowired
    private ActivityStatusRepository activityStatusRepository;
    @Override
    public List<ActivityStatus> findAll() throws Exception {
        return this.activityStatusRepository.findAll();
    }

    @Override
    public ActivityStatus findById(int id) {
        return this.activityStatusRepository.findById(id);
    }

    @Override
    public void create(ActivityStatus activityStatus) {
        this.activityStatusRepository.save(activityStatus);
    }

    @Override
    public void update(ActivityStatus activityStatus) {
        this.activityStatusRepository.save(activityStatus);
    }

    @Override
    public void delete(ActivityStatus activityStatus) {
        this.activityStatusRepository.delete(activityStatus);
    }
}
