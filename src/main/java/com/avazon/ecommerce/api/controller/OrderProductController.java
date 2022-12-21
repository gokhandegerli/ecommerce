package com.avazon.ecommerce.api.controller;


import com.avazon.ecommerce.service.OrderProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-products")
public class OrderProductController {

    private OrderProductService service;

    public OrderProductController(OrderProductService orderProductService) {
        this.service = orderProductService;
    }

}
