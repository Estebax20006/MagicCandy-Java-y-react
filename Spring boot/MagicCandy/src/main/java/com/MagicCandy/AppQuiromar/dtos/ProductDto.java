package com.MagicCandy.AppQuiromar.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int id;

    private String name;

    private String category;

    private int unitPrice;

    private int quantity;

    private byte[] ProductImage;

} 



