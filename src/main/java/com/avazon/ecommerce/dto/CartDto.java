package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.CartProduct;
import com.avazon.ecommerce.response.Meta;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public class CartDto {

    long id;
    double totalPrice;
    UserDto user;
    Set<CartProductDto> cartProducts = new HashSet<>();



}
