package com.avazon.ecommerce.model.entity;


import com.avazon.ecommerce.dto.CartDto;
import com.avazon.ecommerce.dto.UserDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    private static final String MAP_CAT = "cart";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private long id;

    @OneToMany(mappedBy = MAP_CAT, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<CartProduct> cartProducts;

    public Cart() {
    }

    public Cart(long id, List<CartProduct> cartProducts) {
        this.id = id;
        this.cartProducts = cartProducts;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public CartDto toDto() {
        CartDto dto = new CartDto();
        dto.setId(this.getId());
        dto.setCartProducts(this.getCartProducts().stream().map(CartProduct::toDto).toList());
        return dto;
    }

}
