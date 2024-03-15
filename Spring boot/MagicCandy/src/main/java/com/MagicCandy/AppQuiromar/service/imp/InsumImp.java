package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Insum;
import com.MagicCandy.AppQuiromar.repository.InsumRepository;
import com.MagicCandy.AppQuiromar.service.InsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsumImp implements InsumService {
    @Autowired
    private InsumRepository insumRepository;
    @Override
    public List<Insum> findAll() throws Exception {
        return this.insumRepository.findAll();
    }

    @Override
    public Insum findById(int id) {
        return this.insumRepository.findById(id);
    }

    @Override
    public void create(Insum insum) {
        this.insumRepository.save(insum);
    }

    @Override
    public void update(Insum insum) {
        this.insumRepository.save(insum);
    }

    @Override
    public void delete(Insum insum) {
        this.insumRepository.delete(insum);
    }
}
