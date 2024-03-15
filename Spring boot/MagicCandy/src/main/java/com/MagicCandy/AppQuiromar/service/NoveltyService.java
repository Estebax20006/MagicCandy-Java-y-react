package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Novelty;
import java.util.List;

public interface NoveltyService {
    public List<Novelty> findAll() throws Exception;
    public Novelty findById(int id);
    public void create(Novelty novelty);
    public void update(Novelty novelty);
    public void delete(Novelty novelty);
}
