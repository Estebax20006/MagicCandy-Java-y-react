package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.ProductionStatus;
import com.MagicCandy.AppQuiromar.repository.ProductionStatusRepository;
import com.MagicCandy.AppQuiromar.service.ProductionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionStatusImp implements ProductionStatusService {
    @Autowired
    private ProductionStatusRepository productionStatusRepository;
    @Override
    public List<ProductionStatus> findAll() throws Exception {
        return this.productionStatusRepository.findAll();
    }

    @Override
    public ProductionStatus findById(int id) {
        return this.productionStatusRepository.findById(id);
    }

    @Override
    public void create(ProductionStatus productionStatus) {
        this.productionStatusRepository.save(productionStatus);
    }

    @Override
    public void update(ProductionStatus productionStatus) {
        this.productionStatusRepository.save(productionStatus);
    }

    @Override
    public void delete(ProductionStatus productionStatus) {
        this.productionStatusRepository.delete(productionStatus);
    }
}
