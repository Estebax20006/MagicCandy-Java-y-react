package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.Ingredient;
import com.MagicCandy.AppQuiromar.entity.ProductionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionDto {

    private int id;

    private Date startDate;

    private Date endDate;

    private String productProduce;

    private int quantityProduce;

    private String lot;

    private String productQuality;

    private String observations;

}
