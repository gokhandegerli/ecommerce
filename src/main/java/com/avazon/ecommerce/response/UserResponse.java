package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.UserDto;
import lombok.Data;

@Data
public class UserResponse {

    UserDto user = new UserDto();
    Meta meta = new Meta();

    public UserResponse(UserDto user, Meta meta) {
        this.user = user;
        this.meta = meta;
    }

    public UserResponse() {
    }
}
