package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.Cart;
import com.avazon.ecommerce.model.entity.Product;
import com.avazon.ecommerce.response.Meta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CartProductDto {

    long id;
    int quantity;
    ProductDto product;
    @JsonIgnore
    CartDto cart;


}
