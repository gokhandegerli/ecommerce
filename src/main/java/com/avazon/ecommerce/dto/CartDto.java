package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.CartProduct;
import com.avazon.ecommerce.response.Meta;
import lombok.Data;

import java.util.Set;


@Data
public class CartDto {

    long id;
    UserDto user;
    Set<CartProductDto> cartProducts;


}
