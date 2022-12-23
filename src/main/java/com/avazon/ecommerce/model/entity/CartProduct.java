package com.avazon.ecommerce.model.entity;


import com.avazon.ecommerce.dto.CartDto;
import com.avazon.ecommerce.dto.CartProductDto;
import com.avazon.ecommerce.dto.ProductDto;
import jakarta.persistence.*;

@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private long id;
    @Column(nullable=false)
    private int quantity;
    @OneToOne
    private Product product;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cart cart;

    public CartProduct() {
    }

    public CartProduct(long id, int quantity, Product product, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public ProductDto getProductDto() {
        return product == null
                ? null
                : product.toDto(); //If else'in kısa hali
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public CartDto getCartDto() {
        return cart == null
                ? null
                : cart.toDto(); //If else'in kısa hali
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartProductDto toDto () {
        CartProductDto dto = new CartProductDto();
        dto.setId(this.getId());
        dto.setQuantity(this.getQuantity());
        //dto.setCart(this.getCartDto());
        dto.setProduct(this.getProductDto());
        return dto;
    }
}
