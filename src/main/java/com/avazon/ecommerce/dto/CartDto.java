package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.CartProduct;
import com.avazon.ecommerce.response.Meta;
import lombok.Data;

import java.util.List;


@Data
public class CartDto {

    long id;
    List<CartProductDto> cartProducts;


}
