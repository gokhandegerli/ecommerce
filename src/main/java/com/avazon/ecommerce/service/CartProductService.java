package com.avazon.ecommerce.service;


import com.avazon.ecommerce.repository.CartProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartProductService {


    private CartProductRepository repository;

    public CartProductService(CartProductRepository cartProductRepository) {
        this.repository = cartProductRepository;
    }

}
