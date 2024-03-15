package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Inventory;
import com.MagicCandy.AppQuiromar.repository.InventoryRepository;
import com.MagicCandy.AppQuiromar.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryImp implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<Inventory> findAll() throws Exception {
        return this.inventoryRepository.findAll();
    }

    @Override
    public Inventory findById(int id) {
        return this.inventoryRepository.findById(id);
    }

    @Override
    public void create(Inventory inventory) {
        this.inventoryRepository.save(inventory);
    }

    @Override
    public void update(Inventory inventory) {
        this.inventoryRepository.save(inventory);
    }

    @Override
    public void delete(Inventory inventory) {
        this.inventoryRepository.delete(inventory);
    }
}
