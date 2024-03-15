package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Product;
import java.util.List;

public interface ProductService {
    public List<Product> findAll() throws Exception;
    public Product findById(int id);
    public void create(Product product);
    public void update(Product product);
    public void delete(Product product);
}
