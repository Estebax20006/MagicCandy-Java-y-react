package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.NoveltyStatus;
import com.MagicCandy.AppQuiromar.repository.NoveltyRepository;
import com.MagicCandy.AppQuiromar.repository.NoveltyStatusRepository;
import com.MagicCandy.AppQuiromar.service.NoveltyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoveltyStatusImp implements NoveltyStatusService {
    @Autowired
    private NoveltyStatusRepository noveltyStatusRepository;
    @Override
    public List<NoveltyStatus> findAll() throws Exception {
        return this.noveltyStatusRepository.findAll();
    }

    @Override
    public NoveltyStatus findById(int id) {
        return this.noveltyStatusRepository.findById(id);
    }

    @Override
    public void create(NoveltyStatus noveltyStatus) {
        this.noveltyStatusRepository.save(noveltyStatus);
    }

    @Override
    public void update(NoveltyStatus noveltyStatus) {
        this.noveltyStatusRepository.save(noveltyStatus);
    }

    @Override
    public void delete(NoveltyStatus noveltyStatus) {
        this.noveltyStatusRepository.delete(noveltyStatus);
    }
}
