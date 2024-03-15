package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {

    private int id;

    private String receipt;

    private int value;

    private int deliveryQuantity;

    private Date saleDate;

    private Date saleTime;

    private String Detail;



}
