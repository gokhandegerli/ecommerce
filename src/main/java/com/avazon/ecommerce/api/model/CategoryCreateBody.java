package com.avazon.ecommerce.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryCreateBody {

    //@NotNull
    String name;

}
