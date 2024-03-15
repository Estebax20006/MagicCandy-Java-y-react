package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Sale;
import java.util.List;

public interface SaleService {
    public List<Sale> findAll() throws Exception;
    public Sale findById(int id);
    public void create(Sale sale);
    public void update(Sale sale);
    public void delete(Sale sale);
}
