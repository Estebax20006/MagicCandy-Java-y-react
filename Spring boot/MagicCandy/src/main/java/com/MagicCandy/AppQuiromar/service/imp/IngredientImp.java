package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Ingredient;
import com.MagicCandy.AppQuiromar.repository.IngredientRepository;
import com.MagicCandy.AppQuiromar.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientImp implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> findAll() throws Exception {
        return this.ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(int id) {
        return this.ingredientRepository.findById(id);
    }

    @Override
    public void create(Ingredient ingredient) {
        this.ingredientRepository.save(ingredient);
    }

    @Override
    public void update(Ingredient ingredient) {
        this.ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientRepository.delete(ingredient);
    }
}
