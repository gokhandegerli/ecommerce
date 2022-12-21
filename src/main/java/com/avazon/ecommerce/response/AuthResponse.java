package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.AuthDto;
import lombok.Data;

@Data
public class AuthResponse {

    AuthDto userAuth;
    Meta meta = new Meta();

}
