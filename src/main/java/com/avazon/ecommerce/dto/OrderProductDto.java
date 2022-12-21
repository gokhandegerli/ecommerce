package com.avazon.ecommerce.dto;

import lombok.Data;

@Data
public class OrderProductDto {

    long id;
    int quantity;
    ProductDto product;
    OrderDto order;

}
