package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.ProductionStatus;
import java.util.List;

public interface ProductionStatusService {
    public List<ProductionStatus> findAll() throws Exception;
    public ProductionStatus findById(int id);
    public void create(ProductionStatus productionStatus);
    public void update(ProductionStatus productionStatus);
    public void delete(ProductionStatus productionStatus);
}
