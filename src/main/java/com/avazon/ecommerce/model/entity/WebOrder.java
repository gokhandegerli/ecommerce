package com.avazon.ecommerce.model.entity;

import com.avazon.ecommerce.dto.OrderDto;
import com.avazon.ecommerce.dto.UserDto;
import com.avazon.ecommerce.model.enums.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class WebOrder {

    private static final String MAP_CAT = "order";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private long id;

    private OrderStatus status = OrderStatus.WAITING_CONFIRMATION;

    private Date orderedDate;

    private double totalPrice;

    @OneToOne
    private LocalUser user;

    @OneToMany(mappedBy = MAP_CAT,
            cascade = CascadeType.ALL)
    private Set<OrderProduct> orderedProducts = new HashSet<>();;

    public WebOrder() {
    }

    public WebOrder(long id, OrderStatus status, Date orderedDate,
                    double totalPrice, LocalUser user, Set<OrderProduct> orderedProducts) {
        this.id = id;
        this.status = status;
        this.orderedDate = orderedDate;
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

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
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

    public Set<OrderProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Set<OrderProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public OrderDto toDto () {
        OrderDto dto = new OrderDto();
        dto.setId(this.getId());
        dto.setStatus(this.getStatus());
        dto.setOrderedDate(this.getOrderedDate());
        dto.setTotalPrice(this.getTotalPrice());
        dto.setUser(this.getUserDto());
        dto.setOrderedProducts(this.getOrderedProducts().stream().map(OrderProduct::toDto).collect(Collectors.toSet()));
        return dto;
    }

}
