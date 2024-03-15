package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Production;
import com.MagicCandy.AppQuiromar.repository.ProductionRepository;
import com.MagicCandy.AppQuiromar.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionImp implements ProductionService {
    @Autowired
    private ProductionRepository productionRepository;
    @Override
    public List<Production> findAll() throws Exception {
        return this.productionRepository.findAll();
    }

    @Override
    public Production findById(int id) {
        return this.productionRepository.findById(id);
    }

    @Override
    public void create(Production production) {
        this.productionRepository.save(production);
    }

    @Override
    public void update(Production production) {
        this.productionRepository.save(production);
    }

    @Override
    public void delete(Production production) {
        this.productionRepository.delete(production);
    }
}
