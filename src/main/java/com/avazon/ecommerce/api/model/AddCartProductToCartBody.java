package com.avazon.ecommerce.api.model;

import lombok.Data;

@Data
public class AddCartProductToCartBody {

    long productId;
    int quantity;
    long userId;

}
