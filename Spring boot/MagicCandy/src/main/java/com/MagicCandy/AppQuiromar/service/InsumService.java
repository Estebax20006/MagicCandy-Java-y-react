package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Insum;
import java.util.List;

public interface InsumService {
    public List<Insum> findAll() throws Exception;
    public Insum findById(int id);
    public void create(Insum insum);
    public void update(Insum insum);
    public void delete(Insum insum);
}
