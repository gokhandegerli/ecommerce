package com.avazon.ecommerce.api.controller;


import com.avazon.ecommerce.service.CartProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart-products")
public class CartProductController {

    private CartProductService service;

    public CartProductController(CartProductService cartProductService) {
        this.service = cartProductService;
    }
}
