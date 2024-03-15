package com.MagicCandy.AppQuiromar.businnes;

import com.MagicCandy.AppQuiromar.dtos.UserDto;
import com.MagicCandy.AppQuiromar.entity.User;
import com.MagicCandy.AppQuiromar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserBusinnes {

    @Autowired
    private UserService userService;
    private List<User> userList;
    private List<UserDto> userDtoList = new ArrayList<>();

    public List<UserDto> findAll(){
        try {
            this.userList = this.userService.findAll();
            this.userList.forEach(user -> {
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setIdentification(user.getIdentification());
                userDto.setName(user.getName());
                userDto.setLastName(user.getLastName());
                userDto.setAddress(user.getAddress());
                userDto.setPhoneNumber(user.getPhoneNumber());
                userDto.setEmail(user.getEmail());
                userDto.setPassword(user.getPassword());
                this.userDtoList.add(userDto);
            });
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this.userDtoList;
    }

    public String createUser(UserDto userDto){
        String respuesta = "";
        try {
            if (userDto != null){
                User user = new User();
                user.setIdentification(userDto.getIdentification());
                user.setName(userDto.getName());
                user.setLastName(userDto.getLastName());
                user.setAddress(userDto.getAddress());
                user.setPhoneNumber(userDto.getPhoneNumber());
                user.setEmail(userDto.getEmail());
                user.setPassword(userDto.getPassword());

                System.out.println("@@@@@@@@@" + userDto.toString());
                this.userService.create(user);
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
