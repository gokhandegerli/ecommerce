package com.avazon.ecommerce.api.controller;


import com.avazon.ecommerce.response.CartResponse;
import com.avazon.ecommerce.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carts")
public class CartController {

    private CartService service;

    public CartController(CartService cartService) {
        this.service = cartService;
    }

    @GetMapping("get-user-cart/{userId}")
    public CartResponse getCartOfUser(@PathVariable(value = "userId") long userId) {
        return service.getCartOfUser(userId);
    }


}
