package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Sale;
import com.MagicCandy.AppQuiromar.repository.SaleRepository;
import com.MagicCandy.AppQuiromar.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleImp implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Override
    public List<Sale> findAll() throws Exception {
        return this.saleRepository.findAll();
    }

    @Override
    public Sale findById(int id) {
        return this.saleRepository.findById(id);
    }

    @Override
    public void create(Sale sale) {
        this.saleRepository.save(sale);
    }

    @Override
    public void update(Sale sale) {
        this.saleRepository.save(sale);
    }

    @Override
    public void delete(Sale sale) {
        this.saleRepository.delete(sale);
    }
}
