package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Referred;
import java.util.List;

public interface ReferredService {
    public List<Referred> findAll() throws Exception;
    public Referred findById(int id);
    public void create(Referred referred);
    public void update(Referred referred);
    public void delete(Referred referred);
}
