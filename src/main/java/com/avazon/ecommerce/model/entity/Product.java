package com.avazon.ecommerce.model.entity;

import com.avazon.ecommerce.dto.CartDto;
import com.avazon.ecommerce.dto.CategoryDto;
import com.avazon.ecommerce.dto.ProductDto;
import jakarta.persistence.*;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Category category;

    private String description;

    private String picture;

    private double price;

    private int quantity;

    public Product() {
    }

    public Product(long id, String name, Category category,
                   String description, String picture, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public CategoryDto getCategoryDto() {
        return category == null
                ? null
                : category.toDto(); //If else'in kısa hali
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDto toDto() {
        ProductDto dto = new ProductDto();
        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setPrice(this.getPrice());
        dto.setPicture(this.getPicture());
        dto.setDescription(this.getDescription());
        dto.setQuantity(this.getQuantity());
        dto.setCategory(this.getCategoryDto());
        return dto;
    }
}
