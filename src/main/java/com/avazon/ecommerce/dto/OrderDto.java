package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class OrderDto {

    long id;
    OrderStatus status;
    LocalDate orderedDate;
    double totalPrice;
    UserDto user;
    Set<OrderProductDto> orderedProducts = new HashSet<>();

}
