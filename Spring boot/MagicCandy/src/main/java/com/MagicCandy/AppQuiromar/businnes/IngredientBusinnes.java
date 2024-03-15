package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.IngredientDto;
import com.MagicCandy.AppQuiromar.entity.Ingredient;
import com.MagicCandy.AppQuiromar.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientBusinnes {

    @Autowired
    private IngredientService ingredientService;
    private List<Ingredient> ingredientList;
    private List<IngredientDto> ingredientDtoList = new ArrayList<>();

    public List<IngredientDto> findAll(){
        try {
            this.ingredientList = this.ingredientService.findAll();
            this.ingredientList.forEach(ingredient -> {
                IngredientDto ingredientDto = new IngredientDto();
                ingredientDto.setId(ingredient.getId());
                ingredientDto.setSetAmount(ingredient.getSetAmount());
                this.ingredientDtoList.add(ingredientDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.ingredientDtoList;
    }

    public String createIngredient(IngredientDto ingredientDto){
        String respuesta = "";
        try {
            if (ingredientDto != null){
                Ingredient ingredient = new Ingredient();
                ingredient.setSetAmount(ingredientDto.getSetAmount());

                System.out.println("@@@@@@@" + ingredientDto.toString());
                this.ingredientService.create(ingredient);
                respuesta = "Registro exitoso";
            } else {
                respuesta = "Fallo el registro";
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}
