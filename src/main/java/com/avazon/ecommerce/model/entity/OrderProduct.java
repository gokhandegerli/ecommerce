package com.avazon.ecommerce.model.entity;

import com.avazon.ecommerce.dto.OrderProductDto;
import com.avazon.ecommerce.dto.ProductDto;
import com.avazon.ecommerce.dto.OrderDto;
import jakarta.persistence.*;

@Entity
public class OrderProduct {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int quantity;

    @OneToOne
    private Product product;

    @ManyToOne
    private WebOrder order;

    public OrderProduct() {
    }

    public OrderProduct(long id, int quantity, Product product, WebOrder order) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.order = order;
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

    public WebOrder getOrder() {
        return order;
    }

    public OrderDto getOrderDto() {
        return order == null
                ? null
                : order.toDto(); //If else'in kısa hali
    }

    public void setOrder(WebOrder order) {
        this.order = order;
    }

    public OrderProductDto toDto () {
        OrderProductDto dto = new OrderProductDto();
        dto.setId(this.getId());
        dto.setQuantity(this.getQuantity());
        dto.setProduct(this.getProductDto());
        dto.setOrder(this.getOrderDto());
        return dto;
    }
}
