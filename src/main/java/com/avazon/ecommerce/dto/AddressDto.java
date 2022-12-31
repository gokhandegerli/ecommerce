package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.LocalUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AddressDto {

    long id;
    String line;
    String city;
    String country;
    String postCode;
    @JsonIgnore
    UserDto user = new UserDto();


}
