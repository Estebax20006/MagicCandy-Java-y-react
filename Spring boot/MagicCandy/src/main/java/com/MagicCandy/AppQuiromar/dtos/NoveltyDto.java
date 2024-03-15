package com.MagicCandy.AppQuiromar.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoveltyDto {

    private int id;

    private String subject;

    private Date date;

    private Date time;

    private String comment;

}
