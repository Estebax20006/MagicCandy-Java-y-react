package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.Production;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionStatusDto {

    private int id;

    private String name;

}
