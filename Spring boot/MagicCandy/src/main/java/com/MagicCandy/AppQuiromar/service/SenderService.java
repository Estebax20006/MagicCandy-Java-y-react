package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Sender;

import java.util.List;

public interface SenderService {
    public List<Sender> findAll() throws Exception;
    public Sender findById(int id);
    public void create(Sender sender);
    public void update(Sender sender);
    public void delete(Sender sender);
}
