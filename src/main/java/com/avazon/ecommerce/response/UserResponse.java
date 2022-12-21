package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.UserDto;
import lombok.Data;

@Data
public class UserResponse {

    UserDto user;
    Meta meta = new Meta();
}
