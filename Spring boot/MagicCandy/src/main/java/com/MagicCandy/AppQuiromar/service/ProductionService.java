package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Production;
import java.util.List;

public interface ProductionService {
    public List<Production> findAll() throws Exception;
    public Production findById(int id);
    public void create(Production production);
    public void update(Production production);
    public void delete(Production production);
}
