package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.LocalUser;
import lombok.Data;

@Data
public class AddressDto {

    long id;
    String line;
    String city;
    String country;
    String postCode;
    boolean active;
    UserDto user;


}
