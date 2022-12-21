package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.Cart;
import com.avazon.ecommerce.model.entity.Product;
import com.avazon.ecommerce.response.Meta;
import lombok.Data;

@Data
public class CartProductDto {

    long id;
    long quantity;
    ProductDto product;
    CartDto cart;


}
