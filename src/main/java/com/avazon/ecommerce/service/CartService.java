package com.avazon.ecommerce.service;


import com.avazon.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private CartRepository repository;

    public CartService(CartRepository cartRepository) {
        this.repository = cartRepository;
    }

}
