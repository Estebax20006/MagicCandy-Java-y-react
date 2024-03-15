package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Referred;
import com.MagicCandy.AppQuiromar.repository.ReferredRepository;
import com.MagicCandy.AppQuiromar.service.ReferredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReferredImp implements ReferredService {
    @Autowired
    private ReferredRepository referredRepository;
    @Override
    public List<Referred> findAll() throws Exception {
        return this.referredRepository.findAll();
    }

    @Override
    public Referred findById(int id) {
        return this.referredRepository.findById(id);
    }

    @Override
    public void create(Referred referred) {
        this.referredRepository.save(referred);
    }

    @Override
    public void update(Referred referred) {
        this.referredRepository.save(referred);
    }

    @Override
    public void delete(Referred referred) {
        this.referredRepository.delete(referred);
    }
}
