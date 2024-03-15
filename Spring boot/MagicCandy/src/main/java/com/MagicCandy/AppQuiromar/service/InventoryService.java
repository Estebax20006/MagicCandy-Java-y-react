package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Inventory;

import java.util.List;

public interface InventoryService {
    public List<Inventory> findAll() throws Exception;
    public Inventory findById(int id);
    public void create(Inventory inventory);
    public void update(Inventory inventory);
    public void delete(Inventory inventory);
}
