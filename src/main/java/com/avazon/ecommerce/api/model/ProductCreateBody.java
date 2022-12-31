package com.avazon.ecommerce.api.model;


import com.avazon.ecommerce.dto.CategoryDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCreateBody {

    //@NotNull
    String name;
    String description;
    String picture;
    @NotNull
    double price;
    @NotNull
    int quantity;

}
