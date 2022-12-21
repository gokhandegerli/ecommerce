package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.Address;
import com.avazon.ecommerce.model.entity.Cart;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    long id;
    String email;
    String password;
    String name;
    List<AddressDto> addressList;
    CartDto cart;

}
