package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("carts")
public class CartController {

    private CartService service;

    public CartController(CartService cartService) {
        this.service = cartService;
    }
}
