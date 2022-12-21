package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {

    long id;
    OrderStatus status;
    LocalDate createdDate;
    LocalDate deliveredDate;
    double totalPrice;
    UserDto user;
    List<OrderProductDto> orderedProducts;

}
