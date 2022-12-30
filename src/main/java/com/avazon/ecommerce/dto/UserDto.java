package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.Address;
import com.avazon.ecommerce.model.entity.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    long id;
    String email;
    String password;
    String name;

    public UserDto(String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserDto() {
    }
}
