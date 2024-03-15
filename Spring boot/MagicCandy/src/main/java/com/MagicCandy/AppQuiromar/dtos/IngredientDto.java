package com.MagicCandy.AppQuiromar.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {

    private int id;

    private String setAmount; // Cantidad reservada

}
