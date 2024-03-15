package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumDto {

    private int id;

    private String name;

    private String category;

    private int quantity;

    private String unit;

}
