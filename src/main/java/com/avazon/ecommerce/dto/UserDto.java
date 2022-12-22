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
    @JsonIgnore
    List<AddressDto> addressList;
    @JsonIgnore
    CartDto cart;

}
