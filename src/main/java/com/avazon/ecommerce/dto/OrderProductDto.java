package com.avazon.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class OrderProductDto {

    long id;
    int quantity;
    ProductDto product;
    @JsonIgnore
    OrderDto order;

}
