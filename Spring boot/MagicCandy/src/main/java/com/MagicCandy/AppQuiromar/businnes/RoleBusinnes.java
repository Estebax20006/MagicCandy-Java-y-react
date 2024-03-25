package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.RoleDto;
import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoleBusinnes {

    @Autowired
    private RoleService roleService;
    private List<Role> roleList;


    public List<RoleDto> findAll(){
        List<RoleDto> roleDtoList = new ArrayList<>();
        try {
            this.roleList = this.roleService.findAll();
            this.roleList.forEach(role -> {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setName(role.getName());
                roleDtoList.add(roleDto);
            });
        } catch (Exception e){

            System.out.println(e.getMessage());
        }
        return roleDtoList;
    }

    public String createRole(RoleDto roleDto){
        String respuesta = "";
        try {
            if (roleDto != null){
                Role role = new Role();
                role.setName(roleDto.getName());

                System.out.println("@@@@@@@@@" + roleDto.toString());
                this.roleService.create(role);
                respuesta = "Registro exitoso";
            } else {
                respuesta = "Fallo el registro";
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}