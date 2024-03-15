package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.Order;
import com.MagicCandy.AppQuiromar.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String identification;

    private String name;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String email;

    private String password;

    private Role role;

    private List<Order> orderList;

}
