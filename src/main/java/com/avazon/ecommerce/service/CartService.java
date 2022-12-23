package com.avazon.ecommerce.service;


import com.avazon.ecommerce.dto.CartDto;
import com.avazon.ecommerce.model.entity.Cart;
import com.avazon.ecommerce.repository.CartRepository;
import com.avazon.ecommerce.response.CartResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private CartRepository repository;

    public CartService(CartRepository cartRepository) {
        this.repository = cartRepository;
    }


    public Optional<Cart> getCartEntityWithUserId(long userId) {

        return repository.findByUserId(userId);
    }

    public CartResponse getCartOfUser(long userId) {

        Cart cart = getCartEntityWithUserId(userId).get();
        CartDto cartDto = cart.toDto();
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCart(cartDto);
        return cartResponse;
    }


}
