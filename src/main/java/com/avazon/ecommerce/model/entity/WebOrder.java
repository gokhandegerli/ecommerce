package com.avazon.ecommerce.model.entity;

import com.avazon.ecommerce.dto.CategoryDto;
import com.avazon.ecommerce.dto.OrderDto;
import com.avazon.ecommerce.dto.UserDto;
import com.avazon.ecommerce.model.enums.OrderStatus;
import jakarta.persistence.*;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.time.LocalDate;
import java.util.List;

@Entity
public class WebOrder {

    private static final String MAP_CAT = "order";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private long id;

    private OrderStatus status;

    private LocalDate createdDate;

    private LocalDate deliveredDate;

    private double totalPrice;

    @OneToOne
    private LocalUser user;

    @OneToMany(mappedBy = MAP_CAT, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<OrderProduct> orderedProducts;

    public WebOrder() {
    }

    public WebOrder(long id, OrderStatus status, LocalDate createdDate, LocalDate deliveredDate,
                    double totalPrice, LocalUser user, List<OrderProduct> orderedProducts) {
        this.id = id;
        this.status = status;
        this.createdDate = createdDate;
        this.deliveredDate = deliveredDate;
        this.totalPrice = totalPrice;
        this.user = user;
        this.orderedProducts = orderedProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalUser getUser() {
        return user;
    }

    public UserDto getUserDto() {
        return user == null
                ? null
                : user.toDto(); //If else'in kısa hali
    }

    public void setUser(LocalUser localUser) {
        this.user = localUser;
    }

    public List<OrderProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public OrderDto toDto () {
        OrderDto dto = new OrderDto();
        dto.setId(this.getId());
        dto.setStatus(this.getStatus());
        dto.setCreatedDate(this.getCreatedDate());
        dto.setDeliveredDate(this.getDeliveredDate());
        dto.setTotalPrice(this.getTotalPrice());
        dto.setUser(this.getUserDto());
        dto.setOrderedProducts(this.getOrderedProducts().stream().map(OrderProduct::toDto).toList());
        return dto;
    }

}
