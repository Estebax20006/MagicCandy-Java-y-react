package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Novelty;
import com.MagicCandy.AppQuiromar.repository.NoveltyRepository;
import com.MagicCandy.AppQuiromar.service.NoveltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoveltyImp implements NoveltyService {
    @Autowired
    private NoveltyRepository noveltyRepository;
    @Override
    public List<Novelty> findAll() throws Exception {
        return this.noveltyRepository.findAll();
    }

    @Override
    public Novelty findById(int id) {
        return this.noveltyRepository.findById(id);
    }

    @Override
    public void create(Novelty novelty) {
        this.noveltyRepository.save(novelty);
    }

    @Override
    public void update(Novelty novelty) {
        this.noveltyRepository.save(novelty);
    }

    @Override
    public void delete(Novelty novelty) {
        this.noveltyRepository.delete(novelty);
    }
}
