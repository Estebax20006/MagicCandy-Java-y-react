package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.OrderStatus;
import com.MagicCandy.AppQuiromar.entity.Sale;
import com.MagicCandy.AppQuiromar.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int id;

    private Date dateRequest;

    private float value;

    private int quantity;

    private String detail;

}
