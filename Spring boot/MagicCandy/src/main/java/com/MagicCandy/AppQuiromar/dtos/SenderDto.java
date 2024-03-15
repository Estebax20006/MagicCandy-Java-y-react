package com.MagicCandy.AppQuiromar.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenderDto {

    private int id;

    private String name;

    private String lastName;

    private String Role;

}
