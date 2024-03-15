package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Sender;
import com.MagicCandy.AppQuiromar.repository.SenderRepository;
import com.MagicCandy.AppQuiromar.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderImp implements SenderService {
    @Autowired
    private SenderRepository senderRepository;
    @Override
    public List<Sender> findAll() throws Exception {
        return this.senderRepository.findAll();
    }

    @Override
    public Sender findById(int id) {
        return this.senderRepository.findById(id);
    }

    @Override
    public void create(Sender sender) {
        this.senderRepository.save(sender);
    }

    @Override
    public void update(Sender sender) {
        this.senderRepository.save(sender);
    }

    @Override
    public void delete(Sender sender) {
        this.senderRepository.delete(sender);
    }
}
