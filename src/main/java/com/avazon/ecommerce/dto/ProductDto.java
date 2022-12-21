package com.avazon.ecommerce.dto;

import com.avazon.ecommerce.model.entity.Category;
import lombok.Data;

@Data
public class ProductDto {

    long id;
    String name;
    CategoryDto category;
    String description;
    String picture;
    double price;
    int quantity;


}
