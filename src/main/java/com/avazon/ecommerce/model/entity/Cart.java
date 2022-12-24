package com.avazon.ecommerce.model.entity;


import com.avazon.ecommerce.dto.CartDto;
import com.avazon.ecommerce.dto.UserDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Cart implements Serializable {

    private static final String MAP_CAT = "cart";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private long id;

    private double totalPrice;

    @OneToOne
    private LocalUser user;

    @OneToMany(mappedBy = MAP_CAT,
            cascade = CascadeType.ALL)
    Set<CartProduct> cartProducts = new HashSet<>();


    public Cart() {
    }

    public Cart(long id, LocalUser user, Set<CartProduct> cartProducts, double totalPrice) {
        this.id = id;
        this.user = user;
        this.cartProducts = cartProducts;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalUser getUser() {
        return user;
    }

    public UserDto getUserDto() {
        return user == null
                ? null
                : user.toDto(); //If else'in kısa hali
    }

    public void setUser(LocalUser user) {
        this.user = user;
    }

    public Set<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(Set<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartDto toDto() {
        CartDto dto = new CartDto();
        dto.setId(this.getId());
        dto.setUser(this.getUserDto());
        dto.setCartProducts(this.getCartProducts().stream().map(CartProduct::toDto).collect(Collectors.toSet()));
        dto.setTotalPrice(this.getTotalPrice());
        return dto;
    }

}
