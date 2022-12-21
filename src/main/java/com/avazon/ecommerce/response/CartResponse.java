package com.avazon.ecommerce.response;


import com.avazon.ecommerce.dto.CartDto;
import lombok.Data;

@Data
public class CartResponse {

    CartDto cart;
    Meta meta = new Meta();
}
