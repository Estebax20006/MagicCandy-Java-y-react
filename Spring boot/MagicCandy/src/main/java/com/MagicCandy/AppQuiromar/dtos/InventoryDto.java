package com.MagicCandy.AppQuiromar.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {

    private int id;

    private Date entryDate;

    private int entryQuantity;

    private Date expirationDate;

    private int totalQuantity;

    private Date exitDate;

    private String exitDescription;

    private int exitQuantity;

}
