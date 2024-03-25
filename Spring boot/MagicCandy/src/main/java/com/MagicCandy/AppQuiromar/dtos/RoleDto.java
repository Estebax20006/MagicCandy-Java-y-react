package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private int id;

    private String name;

    private List<User> userList;

}
