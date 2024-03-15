package com.MagicCandy.AppQuiromar.dtos;

import com.MagicCandy.AppQuiromar.entity.Activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferredDto {

    private int id;

    private String name;

    private String lastName;

    private String role;

}
