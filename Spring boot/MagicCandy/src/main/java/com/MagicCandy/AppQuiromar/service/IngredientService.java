package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Ingredient;
import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAll() throws Exception;
    public Ingredient findById(int id);
    public void create(Ingredient ingredient);
    public void update(Ingredient ingredient);
    public void delete(Ingredient ingredient);
}
